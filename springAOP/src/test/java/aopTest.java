import com.hwb.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopTest {
    public static void main(String[] args) {
        //application
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        UserService userServiceImp = (UserService) context.getBean("userServiceImp");
        userServiceImp.fun2();

    }
}
