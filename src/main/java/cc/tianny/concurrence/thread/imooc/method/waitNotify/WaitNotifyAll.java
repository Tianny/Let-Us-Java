package cc.tianny.concurrence.thread.imooc.method.waitNotify;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/3
 * Time: 9:15 下午
 * Description: wait & notifyAll 用法
 * Output:
         * Thread-0 got lock
         * Thread-0 waits to start
         * Thread-1 got lock
         * Thread-1 waits to start
         * thread3 notified        // 执行完 notifyAll 后，所有线程被唤醒； 再执行完 synchronized 块后，才会自动释放 monitor 对象锁。将被 Thread-1 或 Thread-2 拿到。
         * Thread-1  waits to end  // Thread-1 拿到锁后，执行完 synchronized 块后，自动释放锁。被 Thread-2 拿到。
         * Thread-0  waits to end  // Thread-2 拿到锁，继续执行完 synchronized 块。
 */
public class WaitNotifyAll implements Runnable {
    // 对象锁
    private static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " got lock");

            try {
                System.out.println(Thread.currentThread().getName() + " waits to start");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + "  waits to end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(() -> {
            synchronized (lock) {
                // notifyAll() 唤醒所有其他线程。
                // 执行完 synchronized 块后，才会自动释放 monitor 对象锁。
                // ⚠️ 如果此时改为 notify，那么只会唤醒一个线程， Thread-1、Thread-2 中只有一个将拿到锁
                lock.notifyAll();
                System.out.println("thread3 notified");
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();
    }
}
