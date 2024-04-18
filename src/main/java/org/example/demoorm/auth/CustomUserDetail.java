package org.example.demoorm.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetail implements UserDetails {

    private Long userId;
    private String userName;
    private String userEmail;

    @JsonIgnore
    private String userPassword;

    private Collection<? extends GrantedAuthority> authorities;
    public CustomUserDetails(Long userId, String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
