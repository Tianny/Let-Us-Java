package cc.tianny.immoc.stop.best;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/25
 * Time: 5:07 下午
 * Description: 假如要被停止的线程正在执行某个子方法，这个时候该如何处理中断？
 *              方法一：在子方法中把中断异常向上抛给父方法，然后在父方法中处理中断
 */
public class BestStopThreadInProdV1 implements Runnable {
    @Override
    public void run() {
        // 在父方法中捕获中断异常
        try {
            while (true) {
                System.out.println("go");
                throwInterrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("检测到中断，保存错误日志");
        }
    }

    // 将中断上抛给给父方法
    private void throwInterrupt() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new BestStopThreadInProdV1());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
