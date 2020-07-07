
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;



public class proxyTest {

    //region 动态代理

    @Test
    public void test() {
        aaProxy aaProxy = new aaProxy();

        myInvovationHandler myInvovationHandler = new myInvovationHandler();

        System.out.println("======实际实现对象======");
        System.out.println("哈希  " + aaProxy.hashCode());
        System.out.println("类型  " + aaProxy.getClass().getName());


        myInvovationHandler.setRealDosomething(aaProxy);
        //proxy p = (proxy) Proxy.newProxyInstance(aaProxy.getClass().getClassLoader(), aaProxy.getClass().getInterfaces(), new myInvovationHandler());
        proxy p = (proxy) myInvovationHandler.getProxy();

        System.out.println("======代理对象======");
        System.out.println("哈希  " + p.hashCode());//这个方法也是被代理的

        System.out.println("类型  " + p.getClass().getName());


        Class<?>[] list = p.getClass().getInterfaces();
        System.out.println("=======代理对象继承的接口====");
        for (Class<?> aClass : list) {
            System.out.println(aClass.getName());
        }
        System.out.println("======代理对象执行方法结果======");
        System.out.println(p.printWay());


    }

    interface proxy {
        String printWay();

        String printWay2();
    }

    class aaProxy implements proxy {
        @Override
        public String printWay() {
            return "aaaaa";
        }

        @Override
        public String printWay2() {
            return "222aaaaa";
        }
    }


    class bbProxy implements proxy {
        @Override
        public String printWay() {
            return "bbbbb";
        }

        @Override
        public String printWay2() {
            return "222bbb";
        }
    }

    class myInvovationHandler implements InvocationHandler {

        private Object realDosomething;

        public void setRealDosomething(Object realDosomething) {
            this.realDosomething = realDosomething;
        }


        public Object getProxy() {
            return Proxy.newProxyInstance(this.getClass().getClassLoader(), realDosomething.getClass().getInterfaces(), this);
            //return Proxy.newProxyInstance(realDosomething.getClass().getClassLoader(), realDosomething.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println(realDosomething.hashCode() + "aaaa实际实现类");
            return method.invoke(realDosomething, args);
        }
    }

    //endregion

    //region CglibProxy


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //enhancer.setSuperclass(this.target.getClass());    // 设置父类
        //注意 父类不能是内部类
        enhancer.setSuperclass(proxyClass.class);

        CglibProxy cglibProxy =new CglibProxy();
        // 设置回调
        enhancer.setCallback(cglibProxy);    // 在调用父类方法时，回调 this.intercept()
        // 创建代理对象
        proxyClass proxyClass=(proxyClass)enhancer.create();
        proxyClass.test();
    }

    //endregion

}

class proxyClass{
    public void test(){
        System.out.println("hello world");
    }
}
class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("do sth before....");
        Object object = proxy.invokeSuper(o, objects);
        System.out.println("do sth after....");
        return object;
    }
}