package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.modules.oms.service.OmsCompanyAddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 公司收发货地址表(OmsCompanyAddress)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:51
 */
@RestController
@RequestMapping("omsCompanyAddress")
public class OmsCompanyAddressController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsCompanyAddressService omsCompanyAddressService;


}