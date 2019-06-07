package com.example.admin.security;

import am.gitc.backend.common.model.AdminUser;
import org.springframework.security.core.authority.AuthorityUtils;

public class SpringUser extends org.springframework.security.core.userdetails.User {

    private AdminUser user;

    public SpringUser(AdminUser user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }

    public AdminUser getUser() {
        return user;
    }
}