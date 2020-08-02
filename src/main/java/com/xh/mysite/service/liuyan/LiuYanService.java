package com.xh.mysite.service.liuyan;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xh.mysite.domain.LiuYan;
import com.xh.mysite.rest.publicvo.PageInfo;

import java.util.List;

/**
 * author  Xiao Hong
 * date  2020/6/20 16:42
 * description
 */

public interface LiuYanService {

    int Add(LiuYan liuYan);

    IPage<LiuYan> getpage(PageInfo pageInfo);
}
