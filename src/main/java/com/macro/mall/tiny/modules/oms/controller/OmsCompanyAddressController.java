package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.oms.entity.OmsCompanyAddress;
import com.macro.mall.tiny.modules.oms.service.OmsCompanyAddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCompanyAddress>> list() {
        List<OmsCompanyAddress> companyAddressList = omsCompanyAddressService.list();
        return CommonResult.success(companyAddressList);
    }

}