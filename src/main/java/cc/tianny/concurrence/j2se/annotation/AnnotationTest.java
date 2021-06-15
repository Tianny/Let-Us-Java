package cc.tianny.concurrence.j2se.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/15
 * Time: 9:14 下午
 * Description: No Description
 */
public class AnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException {
        for (Method m : Class.forName("MyTest").getMethods()) {
            if (m.isAnnotationPresent(Testable.class)) {
                try {
                    m.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
