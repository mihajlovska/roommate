package com.roommate.api.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
