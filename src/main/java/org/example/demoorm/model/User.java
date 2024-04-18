package org.example.demoorm.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames =  "name"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name= "name", nullable = false)
    @NonNull
    private String userName;

    @Column(name= "email", nullable = false)
    @NonNull
    private String userEmail;

    @Column(name= "password", nullable = false)
    @NonNull
    private String userPassword;

    @Column(name = "address", nullable = false)
    private String userAddress;

    @Column(name = "phone_number")
    private String userPhoneNumber;

    @Column(name = "user_bio")
    private String userBio;

    @OneToMany(mappedBy = "user")
    private List<Book> ownedBooks;

    public User(@NonNull String userName, @NonNull String userEmail, @NonNull String userPassword, String userAddress, String userPhoneNumber, String userBio, List<Book> ownedBooks) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userBio = userBio;
        this.ownedBooks = ownedBooks;
    }

    public User() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @NonNull
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(@NonNull String userEmail) {
        this.userEmail = userEmail;
    }

    @NonNull
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(@NonNull String userPassword) {
        this.userPassword = userPassword;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public List<Book> getOwnedBooks() {
        return ownedBooks;
    }

    public void setOwnedBooks(List<Book> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }
}
