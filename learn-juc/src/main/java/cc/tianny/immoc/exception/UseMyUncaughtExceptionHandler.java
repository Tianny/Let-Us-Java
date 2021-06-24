package cc.tianny.immoc.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/9
 * Time: 7:41 下午
 * Description: No Description
 */
public class UseMyUncaughtExceptionHandler implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("自定义异常捕获器"));

        new Thread(new UseMyUncaughtExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseMyUncaughtExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseMyUncaughtExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseMyUncaughtExceptionHandler(), "MyThread-4").start();
    }
}
