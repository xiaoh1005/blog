package com.xh.mysite.service.articlekind;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.mysite.domain.ArticleKind;
import com.xh.mysite.reposiroty.ArticleKindDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2020/6/20 15:33
 * description
 */
@Service
@Slf4j
public class ArticleKindServiceImpl implements ArticleKindService {

    @Resource
    ArticleKindDAO articleKindDAO;

    @Override
    public List<ArticleKind> getList() {
        List<ArticleKind> articleKinds =null;
        try {
            articleKinds = articleKindDAO.selectList(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleKinds;
    }
}
