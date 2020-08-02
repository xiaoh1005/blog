package com.xh.mysite.rest.liuyan;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xh.mysite.domain.LiuYan;
import com.xh.mysite.rest.publicvo.PageInfo;
import com.xh.mysite.rest.publicvo.RequestVO;
import com.xh.mysite.rest.publicvo.ResStatus;
import com.xh.mysite.rest.publicvo.ResponseVO;
import com.xh.mysite.service.liuyan.LiuYanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * author  Xiao Hong
 * date  2020/6/20 16:39
 * description
 */

@RestController
@RequestMapping("api/liuyan")
public class LiuYanRest {

    @Resource
    private LiuYanService liuYanService;


    @PostMapping("/list")
    public ResponseVO getList(@RequestBody RequestVO<PageInfo> vo) {
        PageInfo pageInfo = vo == null ? new PageInfo(1, 8) : vo.getParams();
        IPage<LiuYan> getpage = liuYanService.getpage(pageInfo);
        return ResponseVO.builder().data(getpage).status(ResStatus.SUCCESS).build();
    }

    @PostMapping("/add")
    public ResponseVO add(@RequestBody LiuYan ly, HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        ly.setIpAddress(remoteAddr);
        int add = liuYanService.Add(ly);
        return ResponseVO.builder().data(add).status(ResStatus.SUCCESS).build();
    }
}
