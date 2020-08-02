package com.xh.mysite.service.article;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.mysite.domain.Article;
import com.xh.mysite.reposiroty.ArticleDAO;
import com.xh.mysite.rest.article.vo.GetListByKindVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleDAO articleDAO;


    @Override
    public Article getOne(Long articleId) {
        Article article = null;
        try {
            article = articleDAO.selectOne(new QueryWrapper<Article>().eq("article_Id", articleId));//eq("article_Id", articleId) todo. article_Id 对应于数据库的字段？？
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return article;
    }

    @Override
    public int batchInsert(List<Article> articles) {
        try {
            articles.forEach(articleDAO::insert);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        return 0;
    }

    @Override
    public IPage<Article> getListWithPage(int index, int size) {
        Page<Article> page = new Page<>(index,size);
        IPage<Article> list = null;
        try {
            list = articleDAO.selectPage(page, null);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return list;
    }

    @Override
    public IPage<Article> getListByKind(GetListByKindVO vo) {
        Page<Article> page = new Page<>(vo.getPage(),vo.getPageSize());
        IPage<Article> list = null;
        try {
            list = articleDAO.selectPage(page,new QueryWrapper<Article>().eq("kind", vo.getKindname()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
