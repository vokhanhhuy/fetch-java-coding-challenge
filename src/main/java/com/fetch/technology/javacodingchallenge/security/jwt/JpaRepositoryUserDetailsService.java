package com.fetch.technology.javacodingchallenge.security.jwt;

import com.fetch.technology.javacodingchallenge.entity.User;
import com.fetch.technology.javacodingchallenge.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(JpaRepositoryUserDetailsService.BEAN_NAME)
public class JpaRepositoryUserDetailsService implements UserDetailsService {
    public static final String BEAN_NAME = "JpaRepositoryUserDetailsService";

    private UserRepository userCredentialsRepository;

    public JpaRepositoryUserDetailsService(UserRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //TODO: need to handle when Authorization header is not provided else it show "An Authentication object was not found...."

        User userEntity = userCredentialsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username '%s' not found!", username)));

        return UserPrincipal.create(userEntity);
    }
}
