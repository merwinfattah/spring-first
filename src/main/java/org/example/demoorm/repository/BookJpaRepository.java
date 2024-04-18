package org.example.demoorm.repository;

import jakarta.transaction.Transactional;
import org.example.demoorm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

        @Query(value = "SELECT * FROM books WHERE author = ?1", nativeQuery = true)
        List<Book> findBookByAuthor(String authorName);

        @Query(value = "SELECT * FROM books WHERE author = ?1", nativeQuery = true)
        List<Book> findBookByGenre(String genre);

//        @Transactional
//        void deleteByUserId(long userId);
}
