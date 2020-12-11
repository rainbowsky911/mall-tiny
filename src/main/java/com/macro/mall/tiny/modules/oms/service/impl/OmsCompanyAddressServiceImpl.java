package com.macro.mall.tiny.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.oms.dao.OmsCompanyAddressDao;
import com.macro.mall.tiny.modules.oms.entity.OmsCompanyAddress;
import com.macro.mall.tiny.modules.oms.service.OmsCompanyAddressService;
import org.springframework.stereotype.Service;

/**
 * 公司收发货地址表(OmsCompanyAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-12-11 13:31:51
 */
@Service("omsCompanyAddressService")
public class OmsCompanyAddressServiceImpl extends ServiceImpl<OmsCompanyAddressDao, OmsCompanyAddress> implements OmsCompanyAddressService {

}