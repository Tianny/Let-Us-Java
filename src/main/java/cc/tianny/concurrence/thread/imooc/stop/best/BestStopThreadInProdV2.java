package cc.tianny.concurrence.thread.imooc.stop.best;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/26
 * Time: 2:18 下午
 * Description: 在子方法中捕获中断异常，捕获后会导致当前线程的中断控制位将被清除，父方法执行时将无法感知中断。
 *              方法二：在子方法中重新恢复中断标志位，这样父方法就可以通过对中断控制位的判断来处理中断
 */
public class BestStopThreadInProdV2 implements Runnable{
    @Override
    public void run() {
        // 判断线程中断标志位
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            throwInterrupt();
        }
        System.out.println("检测到了终端，循环打印退出");
    }

    private void throwInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 重新设置线程中断标志位
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable target;
        Thread thread = new Thread(new BestStopThreadInProdV2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
