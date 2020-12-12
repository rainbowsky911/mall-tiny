package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.pms.entity.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品会员价格表(PmsMemberPrice)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-11 13:40:30
 */
public interface PmsMemberPriceDao extends BaseMapper<PmsMemberPrice> {


    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);

}