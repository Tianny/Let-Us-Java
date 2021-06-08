package cc.tianny.concurrence.j2se.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/4
 * Time: 12:13 下午
 * Description: No Description
 */
public class DynamicProxy {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        p.walk();
        p.sayHello();

    }
}

class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
        执行动态代理对象的所有方法时，都会替换成执行如下的 invoke 方法
        proxy：代表动态代理的对象
        method：代表正在执行的方法
        args：代表调用目标方法时传入的参数
         */
        System.out.println("正在执行的方法: " + method);
        if (args != null) {
            System.out.println("下面是执行该方法传入的实参为: ");
            for (Object val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("调用该方法没有实参");
        }
        return null;
    }
}

interface Person {
    void walk();
    void sayHello();
}