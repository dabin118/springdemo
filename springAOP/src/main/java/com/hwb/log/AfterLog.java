package com.hwb.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AfterLog implements AfterReturningAdvice  {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        //System.out.println(o1.getClass().getName()+ "的 "+ method.getName() +" 方法 被执行了；返回结果为 "+ o==null?"null":o);

        System.out.println(o1.getClass().getName()+ "的 "+ method.getName() +" 方法 被执行了；返回结果为 "+ (o==null?"null":o));
    }
}
