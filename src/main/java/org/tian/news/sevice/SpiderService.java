package org.tian.news.sevice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tian.news.entity.NewsTmp;
import org.tian.news.sevice.NewsTmpService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpiderService {
    /**
     * 抓取新闻列表中的新闻项目（标题，内容）
     * @param url       新闻列表链接
     * @param baseUrl   新闻详情链接前需拼接
     * @return          List<NewsTmp>
     * @throws IOException
     */
    public List<NewsTmp> getNewsTmpByUrl(String url, String baseUrl) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements list = doc.select(".dd_bt > a");
        List<NewsTmp> newsList = new ArrayList<>();
        for (Element element : list) {
            Document newsDoc = Jsoup.connect(baseUrl + element.attr("href")).get();
            Elements select = newsDoc.select(".left_zw");
            NewsTmp news = new NewsTmp();
            news.setNTitle(element.html());
            news.setNContent(select.html());
            newsList.add(news);
        }
        return newsList;
    }

}
