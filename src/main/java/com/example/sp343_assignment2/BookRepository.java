package com.example.sp343_assignment2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{isbn: ?0}")
    Book findByIsbn(String isbn);

    @Query("{title: {$regex: ?0}}")
    List<Book> findByTitle(String title);

    @Query("{$and: [{pageCount: {$gte: ?0}}, {pageCount: {$lte: ?1}}]}")
    List<Book> findByPageCount(int lowerBound, int upperBound);
}
