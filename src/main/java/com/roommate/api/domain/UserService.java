package com.roommate.api.domain;

import com.roommate.api.model.Users;

public interface UserService {
    void save(Users user);

    Users findByUsername(String username);
}
