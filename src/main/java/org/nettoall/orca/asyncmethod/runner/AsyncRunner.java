package org.nettoall.orca.asyncmethod.runner;

import java.util.concurrent.CompletableFuture;

import org.nettoall.orca.asyncmethod.model.Account;
import org.nettoall.orca.asyncmethod.service.GithubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * Async Test 용 실행
 */
public class AsyncRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AsyncRunner.class);

    private final GithubLookupService githubLookupService;

    public AsyncRunner(GithubLookupService githubLookupService) {
        this.githubLookupService = githubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        // start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<Account> page1 = githubLookupService.findAccount("PivotalSoftware");
        CompletableFuture<Account> page2 = githubLookupService.findAccount("CloudFoundry");
        CompletableFuture<Account> page3 = githubLookupService.findAccount("Spring-Projects");

        // Wait until they are all done
        // allOf 에 정의된 ComplatableFuture 가 모두 끝났을 때 새로운 ComplatableFuture 반환
        CompletableFuture.allOf(page1, page2, page3).join();

        // Print result, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }
}
