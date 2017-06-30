package com.shahbour.config;

import com.shahbour.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by shahbour on 6/22/17.
 */
@Component
@Slf4j
public class CustomPrincipal implements PrincipalExtractor {

    private static final String[] PRINCIPAL_KEYS = new String[] { "user", "username",
            "userid", "user_id", "login", "id", "name" };

    @Override
    public Object extractPrincipal(Map<String, Object> map) {

        Object principal = map.getOrDefault("principal", null);
        if(principal != null) {
            Map<String,Object> userDetail = (Map) principal;
            User user = new User();
            user.setFirstName(userDetail.get("firstName").toString());
            user.setLastName(userDetail.get("lastName").toString());
            user.setEmail(userDetail.get("email").toString());
            user.setUsername(userDetail.get("username").toString());
            user.setDn(userDetail.get("dn").toString());
            user.setIpPhone(userDetail.get("ipPhone").toString());
//            user.setPhoto(userDetail.get("photo").toString());
            return user;
        } else {
            for (String key : PRINCIPAL_KEYS) {
                if (map.containsKey(key)) {
                    return map.get(key);
                }
            }
        }
        return null;
    }
}
