package com.xh.mysite.rest.publicvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * author  Xiao Hong
 * date  2020/6/20 13:28
 * description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo implements Serializable {

    private Integer page;

    private Integer pageSize;

}
