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
 * date  2020/6/20 16:35
 * description
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@TableName("liuyan")
public class LiuYan implements Serializable {

    @TableId(type = IdType.AUTO)//AUTO:自增 ID_WORKER:雪花算法 生成唯一主键id
    private Integer id;

    private String name;

    private String email;

    private String content;

    private String ipAddress;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;


}
