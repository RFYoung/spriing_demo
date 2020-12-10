package com.example.demo.service;

import com.example.demo.util.MD5Util;


public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode((String) rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {//user Details Service auth
        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
    }

}