package org.tian.news.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "spider")
public class NewsSpiderConfig {
    /**
     * 新闻列表信息
     * ===  新闻类别 新闻类别id 新闻类别名称
     * ===  https://www.chinanews.com/china.shtml 1 时政 ===
     */
    private List<String> urlObjList;

    /**
     * 抓取新闻项目 需要baseUrl拼接
     */
    private String baseUrl;
}
