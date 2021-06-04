package org.tian.news;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tian.news.config.NewsSpiderConfig;
import org.tian.news.entity.NewsTmp;
import org.tian.news.sevice.NewsTmpService;
import org.tian.news.sevice.SpiderService;

import java.util.List;

@SpringBootTest
class NewsSystemApplicationTests {

    @Autowired
    private NewsTmpService newsTmpService;

    @Autowired
    private SpiderService spiderService;

    @Autowired
    private NewsSpiderConfig newsSpiderConfig;

    @Test
    void contextLoads() throws Exception{
        String baseUrl = newsSpiderConfig.getBaseUrl();
        List<String> urlObjList = newsSpiderConfig.getUrlObjList();
        for (int i=0; i<urlObjList.size(); i++){
            String[] params = urlObjList.get(i).split(" ");
            String url = params[0];
            int cid = Integer.parseInt(params[1]);
            List<NewsTmp> newsTmps = spiderService.getNewsTmpByUrl(url, baseUrl);
            for (NewsTmp newsTmp : newsTmps) {
                newsTmp.setNCategoryId(cid);
            }
        }
    }

}
