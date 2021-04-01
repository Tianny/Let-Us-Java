package cc.tianny.concurrence.thread.imooc.stop;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/25
 * Time: 3:19 下午
 * Description: 线程在阻塞状态中被中断; 使用 try-catch 捕获 InterruptedException。
 *              ⚠️ 当捕获 InterruptedException 后，线程的中断状态标志位会被清除。（详见 Thread.sleep 方法注释）
 */
public class StopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 300) {
                    if (num % 100 == 0) {
                        System.out.println(num + " 是 100 的倍数");
                    }
                    num++;
                }
                // 线程在阻塞状态被中断，此时需要捕获 InterruptedException
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
