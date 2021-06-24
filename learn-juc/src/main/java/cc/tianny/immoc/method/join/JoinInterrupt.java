package cc.tianny.immoc.method.join;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/7
 * Time: 3:13 下午
 * Description: Join 被中断情况
 *              thread1.join() 被 try-catch 包裹住的异常处理，是捕获主线程的终端异常，不是 thread1 的
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 主线程手动中断，会在代码的第 32 行中被捕获到 InterruptedException
                    mainThread.interrupt();
                    Thread.sleep(5000);
                    System.out.println("Thread1 finished");
                    // 捕获子线程的异常中断
                } catch (InterruptedException e) {
                    System.out.println("子线程中断");
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
            // ⚠️ 这里是捕获的是主线程的 InterruptedException，而不是子线程 thread1 的
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "线程被中断了");
            // 主线程捕获到主线程的异常中断后，再手动中断子线程。如果这里不手动中断子线程，子线程将继续执行
            thread1.interrupt();
        }
    }
}
