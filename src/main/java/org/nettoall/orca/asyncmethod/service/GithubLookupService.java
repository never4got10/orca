package org.nettoall.orca.asyncmethod.service;

import org.nettoall.orca.asyncmethod.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GithubLookupService {

    private final static Logger logger = LoggerFactory.getLogger(GithubLookupService.class);

    private final RestTemplate restTemplate;

    public GithubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * @Async 는 분리된 thread 로 실행하라는 의미
     * github의 해당 uri는 접속 횟수가 정해져 있는 듯 - 정상적으로 테스트 안 됨
     *
     * @param account
     * @return
     * @throws InterruptedException
     */
    @Async
    public CompletableFuture<Account> findAccount(String account) throws InterruptedException {
        logger.info("Looking up " + account);
        String url = String.format("https://api.github.com/users/%s", account);
        Account results = restTemplate.getForObject(url, Account.class);
        // Artificial delay of 1s of demonstration purpose
        Thread.sleep(1000L);
        // completedFuture 메소드로 CompletableFuture 반환
        return CompletableFuture.completedFuture(results);
    }
}
