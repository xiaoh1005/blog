package com.xh.mysite.domain;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_article")
public class Article implements Serializable {

    @TableId(type = IdType.AUTO)//AUTO:自增 ID_WORKER:雪花算法 生成唯一主键id
    Long id;

    Long articleId;

    String title;

    String summary;

    String content;

    String kind;

    @TableLogic //表字段逻辑处理注解（逻辑删除）
    Integer deleted;

    @Version //乐观锁 CAS 比较字段
    Integer version;

    @TableField(fill = FieldFill.INSERT)
    Date uploadDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date modifyDate;



}
