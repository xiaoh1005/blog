package com.xh.mysite.service.article;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xh.mysite.domain.Article;
import com.xh.mysite.rest.article.vo.GetListByKindVO;

import java.util.List;

public interface ArticleService {

    Article getOne(Long articleId);

    int batchInsert(List<Article> articles);

    IPage<Article> getListWithPage(int index, int size);

    IPage<Article> getListByKind(GetListByKindVO vo);
}
