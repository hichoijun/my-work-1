package com.cj.ggs;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulingConfig {


    /**
     * 每隔5秒执行一次
     */
    @Scheduled(fixedRate = 24*60*60*1000)
    public void reportCurrentTime() {
        new lagou().getInfo();
    }
}
