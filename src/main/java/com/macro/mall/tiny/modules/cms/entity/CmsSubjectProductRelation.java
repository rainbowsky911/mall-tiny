package com.macro.mall.tiny.modules.cms.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 专题商品关系表(CmsSubjectProductRelation)表实体类
 *
 * @author makejava
 * @since 2020-12-11 13:20:16
 */
@SuppressWarnings("serial")

@Data
@Accessors(chain = true)
public class CmsSubjectProductRelation extends Model<CmsSubjectProductRelation> {

    private Long id;

    private Long subjectId;

    private Long productId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}