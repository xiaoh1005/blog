package com.xh.mysite.service.liuyan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.mysite.domain.LiuYan;
import com.xh.mysite.reposiroty.LiuYanDAO;
import com.xh.mysite.rest.publicvo.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2020/6/20 16:42
 * description
 */

@Slf4j
@Service
public class LiuYanServiceImpl implements LiuYanService {


    @Resource
    private LiuYanDAO liuYanDAO;

    @Override
    public int Add(LiuYan liuYan) {
        int insert = -1;
        try {
            insert = liuYanDAO.insert(liuYan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insert;
    }

    @Override
    public IPage<LiuYan> getpage(PageInfo pageInfo) {
        Page<LiuYan> liuYanPage = new Page<>(pageInfo.getPage(), pageInfo.getPageSize());
        IPage<LiuYan> liuYans = null;
        try {
            liuYans = liuYanDAO.selectPage(liuYanPage, new QueryWrapper<LiuYan>().orderByDesc("create_date"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liuYans;
    }
}
