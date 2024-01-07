package org.nettoall.orca.asyncmethod.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class ThreadPoolExecutor {

    /**
     * Spring이 찾는 taskExecutor 란 이름으로 Bean 정의
     * Executor를 정의하지 않으면 Spring은 ThreadPoolExecutor를 기본으로 사용
     * @return
     */
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);   // 동시 수행 thread 수 정의
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);  // queue 길이
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }
}
