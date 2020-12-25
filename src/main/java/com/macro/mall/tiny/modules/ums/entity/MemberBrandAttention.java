package com.macro.mall.tiny.modules.ums.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 会员关注的品牌
 * Created by macro on 2018/8/2.
 */
@Document
@Data
@Accessors(chain = true)
public class MemberBrandAttention {


    @Id
    private String id;
    @Indexed
    private Long memberId;
    private String memberNickname;
    private String memberIcon;
    @Indexed
    private Long brandId;
    private String brandName;
    private String brandLogo;
    private String brandCity;
    private Date createTime;

}
