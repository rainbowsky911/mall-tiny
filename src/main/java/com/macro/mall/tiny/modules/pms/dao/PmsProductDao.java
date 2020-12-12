package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.dto.PmsProductQueryParam;
import com.macro.mall.tiny.modules.pms.dto.PmsProductResult;
import com.macro.mall.tiny.modules.pms.entity.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品信息(PmsProduct)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:40:31
 */
public interface PmsProductDao extends BaseMapper<PmsProduct> {


    /**
     * 查看DTO商品信息类
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(Long id);

    IPage<List<PmsProduct>> getDynamic(Page page, @Param("item") PmsProductQueryParam param);
}