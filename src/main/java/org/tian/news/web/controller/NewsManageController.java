package org.tian.news.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tian.news.entity.Category;
import org.tian.news.entity.News;
import org.tian.news.entity.NewsTmp;
import org.tian.news.sevice.CategoryService;
import org.tian.news.sevice.NewsService;
import org.tian.news.sevice.NewsTmpService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("news_manage")
public class NewsManageController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsTmpService newsTmpService;

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("get_category_list")
    public List<Category> getCategoryList(){
        return categoryService.list();
    }

    @ResponseBody
    @RequestMapping("update_category")
    public Category updateCategory(Category category){
        categoryService.updateById(category);
        return category;
    }

    @ResponseBody
    @RequestMapping("get_news_list")
    public List<News> getNewsList(){
        return newsService.list();
    }

    @ResponseBody
    @RequestMapping("get_news_tmp_list")
    public IPage<NewsTmp> getNewsTmpList(Integer current, Integer pageSize, String title, String content, Integer category){
        QueryWrapper<NewsTmp> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("n_title", title)
                .like("n_content", content)
                .orderByDesc("n_create_time");
        if (null != category && category != 0){
            queryWrapper.eq("n_category_id", category);
        }
        IPage<NewsTmp> page = new Page<>(current, pageSize);
        newsTmpService.page(page, queryWrapper);
        categoryService.fillCname(page.getRecords());
        return page;
    }


    @ResponseBody
    @RequestMapping("update_news")
    public News updateNews(News news){
        newsService.updateById(news);
        //System.out.println(category);
        return news;
    }

    @ResponseBody
    @RequestMapping("add_news")
    public News addNews(@RequestBody Map<String, String> map){
        News news = new News();
        news.setNTitle(map.get("nTitle"));
        news.setNContent(map.get("nContent"));
        news.setNCategoryId(Integer.parseInt(map.get("nCategoryId")));
        // System.out.println(news);
        newsService.save(news);
        return news;
    }

}
