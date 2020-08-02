package com.xh.mysite.rest.publicvo;

import lombok.*;

import java.io.Serializable;

/**
 * author  Xiao Hong
 * date  2020/6/20 12:03
 * description
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO implements Serializable {

    private String status;

    private Object data;

    private String msg;


}

