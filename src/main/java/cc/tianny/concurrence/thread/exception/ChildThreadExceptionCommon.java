package cc.tianny.concurrence.thread.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/9
 * Time: 7:21 下午
 * Description: 模拟子线程抛出异常的情况
 *              ⚠️ 默认情况下，子线程只是抛出异常，打印堆栈信息。但是主线程不会因此中断，继续运行
 *              业务场景：子线程抛出的堆栈信息被淹没在茫茫的日志中，因为主线程仍然继续运行，产生日志。
 */
public class ChildThreadExceptionCommon implements Runnable {


    @Override
    public void run() {
        // 模拟子线程抛出异常
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        new Thread(new ChildThreadExceptionCommon()).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
