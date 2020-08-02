package com.xh.mysite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * author  Xiao Hong
 * date  2020/6/2 23:44
 * description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResource implements Serializable {

    private String uri;
}
