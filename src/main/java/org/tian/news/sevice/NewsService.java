package org.tian.news.sevice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.news.entity.Category;
import org.tian.news.entity.News;
import org.tian.news.mapper.NewsMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<News> list() {
        List<News> newsList = super.list();
        List<Category> categoryList = categoryService.list();

        // 构造类别map
        Map<Integer, String> cMap = new HashMap<>();
        for (Category category : categoryList) {
            cMap.put(category.getCId(), category.getCName());
        }

        for (News news : newsList) {
            news.setNCategoryName(cMap.get(news.getNCategoryId()));
        }
        return newsList;
    }




}
