package cc.tianny.concurrence.thread.stop;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/25
 * Time: 2:28 下午
 * Description: 线程未在阻塞状态下被中断，通过 isInterrupted 方法判断
 */
public class StopThreadWithoutSleep implements Runnable {

    @Override
    public void run() {
        int num = 0;
        // 通过 isInterrupted 来判断线程中断标志位
        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是 10000 的倍数");
            }
            num++;
        }
        System.out.println("线程运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        // 向线程发送 interrupt 通知
        thread.interrupt();
    }
}
