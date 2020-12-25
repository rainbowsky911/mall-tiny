package com.macro.mall.tiny.modules.ums.service;

import com.macro.mall.tiny.modules.ums.entity.MemberProductCollection;
import org.springframework.data.domain.Page;

public interface MemberCollectionService {

    /**
     * 添加收藏
     */
    int add(MemberProductCollection productCollection);

    /**
     * 删除收藏
     */
    int delete(Long productId);

    /**
     * 分页查询收藏
     */
    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    /**
     * 查看收藏详情
     * @return
     */
    MemberProductCollection detail(Long productId);

    /**
     * 清空收藏
     */
    void clear();
}
