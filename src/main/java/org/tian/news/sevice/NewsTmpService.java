package org.tian.news.sevice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.news.entity.Category;
import org.tian.news.entity.News;
import org.tian.news.entity.NewsTmp;
import org.tian.news.mapper.NewsMapper;
import org.tian.news.mapper.NewsTmpMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsTmpService extends ServiceImpl<NewsTmpMapper, NewsTmp> {

    @Autowired
    private CategoryService categoryService;

    /**
     * 保存前重复检查
     * @param entity
     * @return
     */
    @Override
    public boolean save(NewsTmp entity) {
        if (isExist(entity)){
            return false;
        }
        return super.save(entity);
    }

    /**
     * 是否存在重复标题新闻
     * @param entity
     * @return
     */
    public boolean isExist(NewsTmp entity){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("n_title", entity.getNTitle());
        int count = count(queryWrapper);
        return count>0 ? true:false;
    }
}
