package com.macro.mall.tiny.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.sms.dao.SmsHomeNewProductDao;
import com.macro.mall.tiny.modules.sms.entity.SmsHomeNewProduct;
import com.macro.mall.tiny.modules.sms.service.SmsHomeNewProductService;
import org.springframework.stereotype.Service;

/**
 * 新鲜好物表(SmsHomeNewProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:44:02
 */
@Service("smsHomeNewProductService")
public class SmsHomeNewProductServiceImpl extends ServiceImpl<SmsHomeNewProductDao, SmsHomeNewProduct> implements SmsHomeNewProductService {

}