package org.nettoall.orca.schedulingtasks.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * org.awaitility:awaitility library 추가
 *
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    /**
     * scheduled 사용법
     * @Scheduled annotation 사용
     * fixedDelay, cron 등 사용 가능
     * SpringBootApplication 에 @EnableScheduling annotation 정의
     * fixedRate ms 로 설정
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", sdf.format(new Date()));
    }
}
