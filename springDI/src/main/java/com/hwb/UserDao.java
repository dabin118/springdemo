package com.hwb;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public String sayHello(String name);
}
