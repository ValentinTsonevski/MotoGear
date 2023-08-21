package com.example.motogear.service;

import com.example.motogear.domain.entity.UserEntity;
import com.example.motogear.domain.entity.UserRoleEntity;
import com.example.motogear.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return
                userRepository.
                        findByUsername(username).
                        map(this::mapUserDetails).
                        orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found",username)));
    }

    private UserDetails mapUserDetails(UserEntity userEntity) {
        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                extractAuthorities(userEntity)
        );

    }

    private List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
        return userEntity.
                getRoles().
                stream().
                map(this::mapRole).
                toList();
    }

    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
    }

}
