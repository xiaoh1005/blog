package com.xh.mysite.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * author  Xiao Hong
 * date  2020/6/20 14:59
 * description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_articlekind")
public class ArticleKind implements Serializable {

    @TableId(type = IdType.AUTO)//AUTO:自增 ID_WORKER:雪花算法 生成唯一主键id
    Integer id;

    Integer kindid;

    String kindname;

    Integer num;

    @TableField(fill = FieldFill.INSERT)
    Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    Date modifyDate;

    @TableLogic //表字段逻辑处理注解（逻辑删除）
    Integer deleted;

}
