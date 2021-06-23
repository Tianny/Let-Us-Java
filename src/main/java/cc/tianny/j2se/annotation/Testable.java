package cc.tianny.j2se.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/15
 * Time: 9:12 下午
 * Description: No Description
 */
// 使得该注解可以保留到运行时（保证 JVM 可以获得该注解的信息）
@Retention(RetentionPolicy.RUNTIME)
// 使得该注解只能修饰方法
@Target(ElementType.METHOD)
public @interface Testable {
}
