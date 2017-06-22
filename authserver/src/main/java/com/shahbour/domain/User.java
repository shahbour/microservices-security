package com.shahbour.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by shahbour on 6/21/17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails { //implements LdapUserDetails

//    public User(LdapUserDetails userDetails) {
//        this.setUsername(userDetails.getUsername());
//        this.setAuthorities(userDetails.getAuthorities());
//        this.setAccountNonExpired(userDetails.isAccountNonExpired());
//        this.setAccountNonLocked(userDetails.isAccountNonLocked());
//        this.setCredentialsNonExpired(userDetails.isCredentialsNonExpired());
//        this.setEnabled(userDetails.isEnabled());
//        this.setDn(userDetails.getDn());
//        this.setEmail(userDetails.getUsername());
//    }

    public User(UserDetails userDetails) {
        this.setUsername(userDetails.getUsername());
        this.setAuthorities(userDetails.getAuthorities());
        this.setAccountNonExpired(userDetails.isAccountNonExpired());
        this.setAccountNonLocked(userDetails.isAccountNonLocked());
        this.setCredentialsNonExpired(userDetails.isCredentialsNonExpired());
        this.setEnabled(userDetails.isEnabled());
        this.setEmail(userDetails.getUsername());
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

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