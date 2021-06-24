package cc.tianny.immoc.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/9
 * Time: 7:39 下午
 * Description: 实现 UncaughtExceptionHandler 接口实现自定义异常处理器
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常终止: " + t.getName());
    }
}
