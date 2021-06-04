package org.tian.news.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.tian.news.entity.NewsTmp;
import org.tian.news.sevice.NewsTmpService;
import org.tian.news.sevice.SpiderService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableScheduling
public class NewsSpiderTask {
    @Autowired
    private SpiderService spiderService;

    @Autowired
    private NewsTmpService newsTmpService;

    @Autowired
    private NewsSpiderConfig newsSpiderConfig;

    // 添加定时任务  1h
    @Scheduled(cron = "0 0 0/1 * * ?")
    private void configureTasks() {
        try {
            getAndSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAndSave() throws IOException {
        String baseUrl = newsSpiderConfig.getBaseUrl();
        List<String> urlObjList = newsSpiderConfig.getUrlObjList();
        for (int i=0; i<urlObjList.size(); i++){
            String[] params = urlObjList.get(i).split(" ");
            String url = params[0];
            int cid = Integer.parseInt(params[1]);
            List<NewsTmp> newsTmps = spiderService.getNewsTmpByUrl(url, baseUrl);
            for (NewsTmp newsTmp : newsTmps) {
                newsTmp.setNCategoryId(cid);
                newsTmpService.save(newsTmp);
            }
        }
    }

}
