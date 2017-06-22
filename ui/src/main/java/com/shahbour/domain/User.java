package com.shahbour.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by shahbour on 6/22/17.
 */
@Getter
@Setter
public class User {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

//    private Collection<? extends GrantedAuthority> authorities;

    private String username;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    private String dn;

    private String ipPhone;

    private String photo;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
