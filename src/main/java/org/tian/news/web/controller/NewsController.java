package org.tian.news.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tian.news.entity.News;
import org.tian.news.entity.NewsTmp;
import org.tian.news.sevice.NewsService;
import org.tian.news.vo.NewsPageVO;
import org.tian.news.vo.PageVO;

@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 获取新闻列表分页
     * @param pageVO
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public IPage<News> list(NewsPageVO pageVO){
        return newsService.getListPage(pageVO);
    }

    /**
     * 获取新闻详情
     * @param nid
     * @return
     */
    @RequestMapping("item")
    @ResponseBody
    public News item(Integer nid){
        return newsService.getById(nid);
    }
}
