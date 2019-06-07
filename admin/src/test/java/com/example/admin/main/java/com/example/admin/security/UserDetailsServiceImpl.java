package com.example.admin.security;

import am.gitc.backend.common.model.AdminUser;
import am.gitc.backend.common.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AdminUser byEmail = userRepository.findByEmail(s);
        if (byEmail == null) {
            throw new UsernameNotFoundException("AdminUser with does not exists");
        }
        return new SpringUser(byEmail);
    }
}
