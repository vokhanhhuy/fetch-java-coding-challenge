package com.fetch.technology.javacodingchallenge.security.jwt;

import com.fetch.technology.javacodingchallenge.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * UserDetails implementation class for storing Id and others from User repository
 */
public class UserPrincipal implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    private UserPrincipal() {
        // no-op
    }

    public static UserPrincipal create(User userEntity) {
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.username = userEntity.getUsername();
        userPrincipal.password = userEntity.getPassword();
        userPrincipal.id = userEntity.getId();
        if (StringUtils.hasText(userEntity.getRoles())) {
            List<GrantedAuthority> grantedAuthorities = Arrays.stream(userEntity.getRoles().split(","))
                    .filter(StringUtils::hasText)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            userPrincipal.authorities.addAll(grantedAuthorities);
        }

        return userPrincipal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.unmodifiableCollection(authorities);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
