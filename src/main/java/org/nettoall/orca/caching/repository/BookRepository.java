package org.nettoall.orca.caching.repository;

import org.nettoall.orca.caching.model.Book;

/**
 * repository interface를 구현
 * Concrete class 를 구현하여  sql 이나 nosql로부터 정보를 가져올 수 있는 class 구현
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
