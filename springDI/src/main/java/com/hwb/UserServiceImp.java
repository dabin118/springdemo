package com.hwb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;
    public String sayHello(String name) {
        return userDao.sayHello(name);
    }
}
