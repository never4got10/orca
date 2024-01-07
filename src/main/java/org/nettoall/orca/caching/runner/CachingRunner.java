package org.nettoall.orca.caching.runner;

import org.nettoall.orca.caching.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

//@Component
public class CachingRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CachingRunner.class);

    private final BookRepository bookRepository;

    public CachingRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * @Cacheale 추가하고 안 하고 차이가 남.
     * 추가 안 했을 시 아래 실행시 매번 3초씩 대기 시간이 걸리나 했을 시 이미 호출된 건은 캐싱되어 처리
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("......Fetching books");
        logger.info("isbn-1234 --> " + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-5678 --> " + bookRepository.getByIsbn("isbn-5678"));
        logger.info("isbn-1234 --> " + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-5678 --> " + bookRepository.getByIsbn("isbn-5678"));
        logger.info("isbn-1234 --> " + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-1234 --> " + bookRepository.getByIsbn("isbn-1234"));
    }
}
