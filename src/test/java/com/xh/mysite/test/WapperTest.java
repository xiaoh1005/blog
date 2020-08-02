package com.xh.mysite.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.mysite.domain.Article;
import com.xh.mysite.reposiroty.ArticleDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * author  Xiao Hong
 * date  2020/5/1 23:51
 * description 测试条件构造器 Wapper
 */

@SpringBootTest
public class WapperTest {


    @Autowired
    ArticleDAO articleDAO;

    @Test
    void testQueryWapper(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("title",2)
                .isNotNull("version");
        List<Article> list = articleDAO.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * 模糊查询
     *
     */
    @Test
    void testQueryWappe2r(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("article_id","2")
                .like("content","1")
                .likeLeft("content","1");
        List<Map<String,Object>> list = articleDAO.selectMaps(queryWrapper);//selectMaps Map结果
        list.forEach(System.out::println);
    }


    /**
     * 联查
     *  SELECT
     *         id,
     *         article_id,
     *         title,
     *         summary,
     *         content,
     *         deleted,
     *         version,
     *         upload_date,
     *         modify_date
     *     FROM
     *         tbl_article
     *     WHERE
     *         deleted=0
     *         AND id IN (
     *             select
     *                 id
     *             from
     *                 tbl_article
     *             where
     *                 id <3
     *         )
     */
    @Test
    void testQueryWapper3(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        queryWrapper
                .inSql("id","select id from tbl_article where id <3");

        List<Object> list = articleDAO.selectObjs(queryWrapper);//selectMaps Map结果
        list.forEach(System.out::println);
    }

}
