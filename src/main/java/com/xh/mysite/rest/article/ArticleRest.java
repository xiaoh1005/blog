package com.xh.mysite.rest.article;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xh.mysite.domain.Article;
import com.xh.mysite.rest.publicvo.RequestVO;
import com.xh.mysite.rest.publicvo.ResStatus;
import com.xh.mysite.rest.publicvo.ResponseVO;
import com.xh.mysite.rest.article.vo.GetListByKindVO;
import com.xh.mysite.rest.publicvo.PageInfo;
import com.xh.mysite.service.article.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("api/article")
public class ArticleRest {

    @Resource
    private ArticleService articleService;


    @GetMapping("/articleDetial")
    public ResponseVO batchInsert(Long articleId){
        Article one = articleService.getOne(articleId);
//        System.out.println(one.getContent());
        return ResponseVO.builder().data(one).status(ResStatus.SUCCESS).build();
    }

    @PostMapping("/getByTags")
    public ResponseVO getListByKind(@RequestBody RequestVO<GetListByKindVO> vo){
        IPage<Article> listWithPage = articleService.getListByKind(vo.getParams());
        return ResponseVO.builder().data(listWithPage).status("success").build();
    }

    @PostMapping("/articleList")
    public ResponseVO getList(@RequestBody RequestVO<PageInfo> pageInfo){
        IPage<Article> listWithPage = articleService.getListWithPage(pageInfo.getParams().getPage(), pageInfo.getParams().getPageSize());
        return ResponseVO.builder().data(listWithPage).status("success").build();
    }


}
