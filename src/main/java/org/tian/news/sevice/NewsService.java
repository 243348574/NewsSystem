package org.tian.news.sevice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.news.entity.Category;
import org.tian.news.entity.News;
import org.tian.news.mapper.NewsMapper;
import org.tian.news.vo.NewsPageVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {

    /**
     * 获取新闻列表分页
     * @param pageVO
     * @return
     */
    public IPage<News> getListPage(NewsPageVO pageVO) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("n_id", "n_title", "n_create_time")
                .eq("n_status", 1)
                .eq("n_category_id", pageVO.getCategory());
        IPage<News> newsIPage = new Page<>(pageVO.getCurrent(), pageVO.getLimit());
        return super.page(newsIPage, queryWrapper);
    }
}
