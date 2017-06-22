package com.shahbour.config;

import com.shahbour.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shahbour on 6/21/17.
 */
@Component("userMemoryRepositoryUserDetailsService")
public class UserMemoryRepositoryUserDetailsService  implements UserDetailsService {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public UserMemoryRepositoryUserDetailsService() {
        List<UserDetails> users = new ArrayList<UserDetails>();
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User("user", "password", AuthorityUtils.createAuthorityList("ROLE_TRUNKGROUP","ROLE_FORM","ROLE_GROUPING","ROLE_SUPPORT","ROLE_MEDIA","ROLE_ROUTING","ROLE_RATE","ROLE_AUTOCALL"));
        users.add(user);
        this.inMemoryUserDetailsManager = new InMemoryUserDetailsManager(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = inMemoryUserDetailsManager.loadUserByUsername(username.toLowerCase());
        User user = new User(userDetails);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setEmail("shahbour@gmail.com");
        user.setIpPhone("121");
        user.setFirstName(username);
        user.setLastName(username);
        user.setDn(username);
        user.setUsername("user");
        user.setPassword("password");
        return user;
    }

}

