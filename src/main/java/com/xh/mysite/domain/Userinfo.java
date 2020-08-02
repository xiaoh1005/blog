package com.xh.mysite.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * author  Xiao Hong
 * date  2020/6/2 23:21
 * description
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Userinfo implements Serializable {

    @TableId(type = IdType.ID_WORKER)//AUTO:自增 ID_WORKER:雪花算法 生成唯一主键id
    private Long id;

    private String name;

    private String password;

    private String phone;

    @TableField(fill = FieldFill.INSERT)
    private Date editDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date addDate;

    private String status;

    @Version //乐观锁 CAS 比较字段
    private Integer version;

}
