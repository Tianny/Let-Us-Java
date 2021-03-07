package cc.tianny.concurrence.thread.method.extend;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/6
 * Time: 7:04 下午
 * Description: 使用 synchronized 关键字实现两个线程交替打印奇偶数
 *              缺点：由 CPU 调度线程是否拿到 monitor 锁；
 *              存在一个线程拿到 monitor 锁，但是不满足判断奇偶数条件，会重复循环判断，知道另一个线程拿到 monitor 锁；
 */
public class PrintOddEvenV1 {
    private static int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "打印偶数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        }, "打印奇数线程").start();
    }
}
