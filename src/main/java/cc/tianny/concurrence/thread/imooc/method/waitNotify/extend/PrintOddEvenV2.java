package cc.tianny.concurrence.thread.imooc.method.waitNotify.extend;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/7
 * Time: 10:47 上午
 * Description: 使用 wait & notify 关键字实现两个线程交替打印奇偶数
 * 手动控制 monitor 锁的释放与获取
 */
public class PrintOddEvenV2 {
    private static int count = 0;
    private static final Object lock = new Object();

    static class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    // 拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    // 打印完，唤醒其他线程，再使自己进入休眠
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TurningRunner()).start();
        new Thread(new TurningRunner()).start();
    }
}
