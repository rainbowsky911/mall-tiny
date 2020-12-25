package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.macro.mall.tiny.common.DateUtil;
import com.macro.mall.tiny.modules.cms.entity.CmsSubject;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import com.macro.mall.tiny.modules.sms.entity.SmsFlashPromotion;
import com.macro.mall.tiny.modules.sms.entity.SmsFlashPromotionSession;
import com.macro.mall.tiny.modules.sms.entity.SmsHomeAdvertise;
import com.macro.mall.tiny.modules.sms.service.SmsFlashPromotionService;
import com.macro.mall.tiny.modules.sms.service.SmsFlashPromotionSessionService;
import com.macro.mall.tiny.modules.sms.service.SmsHomeAdvertiseService;
import com.macro.mall.tiny.modules.ums.dao.HomeDao;
import com.macro.mall.tiny.modules.ums.entity.FlashPromotionProduct;
import com.macro.mall.tiny.modules.ums.entity.HomeContentResult;
import com.macro.mall.tiny.modules.ums.entity.HomeFlashPromotion;
import com.macro.mall.tiny.modules.ums.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private SmsHomeAdvertiseService smsHomeAdvertiseService;
    @Autowired
    private SmsFlashPromotionService smsFlashPromotionService;

    @Autowired
    private SmsFlashPromotionSessionService smsFlashPromotionSessionService;

    @Autowired
    private HomeDao homeDao;


    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐品牌
        result.setBrandList(homeDao.getRecommendBrandList(0, 6));
        //获取秒杀信息
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取新品推荐
        result.setNewProductList(homeDao.getNewProductList(0, 4));
        //获取人气推荐
        result.setHotProductList(homeDao.getHotProductList(0, 4));
        //获取推荐专题
        result.setSubjectList(homeDao.getRecommendSubjectList(0, 4));
        return result;
    }

    @Override
    public List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        return homeDao.getHotProductList(offset, pageSize);
    }

    @Override
    public List<PmsProduct> newProductList(Integer pageSize, Integer pageNum) {
        int offset = pageSize * (pageNum - 1);
        return homeDao.getNewProductList(offset, pageSize);
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        int offset = pageSize * (pageNum - 1);
        return homeDao.getNewProductList(offset, pageSize);
    }

    @Override
    public List<CmsSubject> subjectList(Integer pageSize, Integer pageNum) {
        int offset = pageSize * (pageNum - 1);
        return homeDao.getRecommendSubjectList(offset, pageSize);
    }


    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if (nextSession != null) {
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

    private SmsFlashPromotionSession getNextFlashPromotionSession(Date startTime) {

        List<SmsFlashPromotionSession> promotionSessionList = smsFlashPromotionSessionService
                .list(new LambdaQueryWrapper<SmsFlashPromotionSession>()
                        .ge(SmsFlashPromotionSession::getStartTime, startTime));

        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
        Date currTime = DateUtil.getTime(date);
        List<SmsFlashPromotionSession> promotionSessionList = smsFlashPromotionSessionService
                .list(new LambdaQueryWrapper<SmsFlashPromotionSession>()
                        .ge(SmsFlashPromotionSession::getStartTime, "08:00:29")
                        .le(SmsFlashPromotionSession::getEndTime, "09:00:33"));
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    //根据时间获取秒杀活动
    private SmsFlashPromotion getFlashPromotion(Date date) {
        Date currDate = DateUtil.getDate(date);
        List<SmsFlashPromotion> promotions = smsFlashPromotionService
                .list(new LambdaQueryWrapper<SmsFlashPromotion>().ge(SmsFlashPromotion::getStartDate, currDate)
                        .le(SmsFlashPromotion::getEndDate, currDate));
        if (!CollectionUtils.isEmpty(promotions)) {
            return promotions.get(0);
        }
        return null;
    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        return smsHomeAdvertiseService.list(new LambdaQueryWrapper<SmsHomeAdvertise>()
                .eq(SmsHomeAdvertise::getType, 1)
                .eq(SmsHomeAdvertise::getStatus, 1)
                .orderByDesc(SmsHomeAdvertise::getSort));
    }
}
