package com.macro.mall.tiny.modules.oms.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsCartItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车表(OmsCartItem)表控制层
 *
 * @author makejava
 * @since 2020-12-11 13:31:50
 */
@RestController
@RequestMapping("cartItem")
public class OmsCartItemController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OmsCartItemService omsCartItemService;

    @ApiOperation("添加商品到购物车")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody OmsCartItem cartItem) {
        int count = omsCartItemService.add(cartItem);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("购物车列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCartItem>> getList(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsCartItem> list = omsCartItemService.list(null);
        return CommonResult.success(list);
    }

}