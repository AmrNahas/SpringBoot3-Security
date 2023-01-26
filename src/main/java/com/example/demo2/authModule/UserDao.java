package com.example.demo2.authModule;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final static List<UserDetails> APP_USERS = List.of(
            new User("2403660562", "12356", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ));


    public UserDetails findUserByIdentification(String idNum) {
        return APP_USERS.stream().filter(u -> u.getUsername().equals(idNum)).
                findAny().orElseThrow(() -> new UsernameNotFoundException("No Users"));

    }


}
