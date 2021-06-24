package cc.tianny.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/8
 * Time: 7:27 上午
 * Description: No Description
 */
public class AOP {

}

interface Dog {
    void info();
    void run();
}

class GunDog implements Dog {

    @Override
    public void info() {
        System.out.println("我是一只猎狗");
    }

    @Override
    public void run() {
        System.out.println("我奔跑迅速");
    }
}

class DogUtil {
    // 第一个拦截器
    public void method1() {
        System.out.println("----模拟第一个通用方法----");
    }

    // 第二个拦截器
    public void method2() {
        System.out.println("----模拟第二个通用方法----");
    }
}

class MyInvocationHandler1 implements InvocationHandler {
    // 需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 执行动态代理对象的所有方法都将被替换成执行如下的 invoke 方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil dogUtil = new DogUtil();
        // 执行通用方法 method1
        dogUtil.method1();
        // 以 target 作为主调来执行 method 方法
        Object result = method.invoke(target, args);
        // 执行通用方法 method2
        dogUtil.method2();
        return result;
    }
}

class MyProxyFactory {
    // 为指定的 target 生成动态代理对象
    public static Object getProxy(Object target) {
        MyInvocationHandler1 handler1 = new MyInvocationHandler1();
        // 为 MyInvocationHandler1 设置 target 对象
        handler1.setTarget(target);
        // 创建并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler1);
    }
}

class Test {
    public static void main(String[] args) {
        // 创建一个原始的 GunDog 对象，作为 target
        Dog target = new GunDog();
        // 以指定的 target 来创建动态代理对象
        Dog dog = (Dog)MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}