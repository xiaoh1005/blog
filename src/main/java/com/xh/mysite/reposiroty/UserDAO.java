package com.xh.mysite.reposiroty;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.mysite.domain.Userinfo;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO extends BaseMapper<Userinfo> {

}
