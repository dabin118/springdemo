package com.hwb;


import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{
    public String sayHello(String name) {
        return "hello " + name;
    }
}
