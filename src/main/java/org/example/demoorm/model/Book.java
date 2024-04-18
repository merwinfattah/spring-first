package org.example.demoorm.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

@Entity
@Table( name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @Column(name= "title", nullable = false)
    @NonNull
    private String bookTitle;

    @Column(name = "author")
    private String bookAuthor;

    @Column(name = "genre")
    private String bookGenre;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Book() {
    }

    public Book(@NonNull String bookTitle, String bookAuthor, String bookGenre, User user) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.user = user;
    }

    @NonNull
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(@NonNull String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
