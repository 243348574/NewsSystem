package org.tian.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.tian.news.entity.News;
import org.tian.news.entity.NewsTmp;

@Mapper
public interface NewsTmpMapper extends BaseMapper<NewsTmp> {
}
