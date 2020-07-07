import com.hwb.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceImpTest {

    @Test
    public void sayHello() {


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserService userServiceImp1 = (UserService) context.getBean("userServiceImp");


        System.out.println(userServiceImp1.sayHello("aaa"));

    }




}
