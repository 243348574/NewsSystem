package org.tian.news.sevice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.tian.news.entity.Category;
import org.tian.news.entity.NewsTmp;
import org.tian.news.mapper.CategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {

}
