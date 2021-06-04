package org.tian.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.tian.news.entity.Category;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
