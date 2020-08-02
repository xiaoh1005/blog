package com.xh.mysite.rest.article.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * author: Xiao Hong
 * date: 2020/5/1 22:56
 * description: VO for  ListWithPageVO
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetListByKindVO implements Serializable {

    private Integer page;

    private Integer pageSize;

    private String kindname;


}
