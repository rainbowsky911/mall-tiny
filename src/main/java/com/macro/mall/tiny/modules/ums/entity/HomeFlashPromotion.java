package com.macro.mall.tiny.modules.ums.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * 首页当前秒杀场次信息
 */
@Data
@Accessors(chain = true)
public class HomeFlashPromotion {
    private Date startTime;
    private Date endTime;
    private Date nextStartTime;
    private Date nextEndTime;
    //属于该秒杀活动的商品
    private List<FlashPromotionProduct> productList;
}

