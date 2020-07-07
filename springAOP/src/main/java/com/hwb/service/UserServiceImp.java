package com.hwb.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Override
    public void fun() {
        System.out.println("fun");
    }

    @Override
    public void fun2() {
        System.out.println("fun2");
    }

    @Override
    public void fun3() {
        System.out.println("fun3");
    }
}
