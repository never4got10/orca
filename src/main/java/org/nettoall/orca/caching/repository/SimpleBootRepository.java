package org.nettoall.orca.caching.repository;

import org.springframework.cache.annotation.Cacheable;
import org.nettoall.orca.caching.model.Book;
import org.springframework.stereotype.Component;

@Component
public class SimpleBootRepository implements BookRepository {

    /**
     * Book을 가져오기 전 3초간 지연 시팀
     * @Cacheable("books") 로 캐싱 기능 추가
     *
     * @param isbn
     * @return
     */
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some Book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch(InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
