package com.xh.mysite.rest.articlekind;

import com.xh.mysite.domain.ArticleKind;
import com.xh.mysite.rest.publicvo.ResStatus;
import com.xh.mysite.rest.publicvo.ResponseVO;
import com.xh.mysite.service.articlekind.ArticleKindService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2020/6/20 15:31
 * description
 */

@RestController
@RequestMapping("api/articlekind")
public class ArticleKindRest {

    @Resource
    ArticleKindService articleKindService;

    @RequestMapping("/kinds")
    public ResponseVO getList() {
        List<ArticleKind> list = articleKindService.getList();
        return ResponseVO.builder().data(list).status(ResStatus.SUCCESS).build();
    }
}
