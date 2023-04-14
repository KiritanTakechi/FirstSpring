package com.ouka.service;

public interface RegisterService {
    boolean register(String nickname, String username, String password);
    boolean isRegistered(String username);
}
