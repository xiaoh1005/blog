package com.xh.mysite.reposiroty;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.mysite.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO extends BaseMapper<Article> {


}
