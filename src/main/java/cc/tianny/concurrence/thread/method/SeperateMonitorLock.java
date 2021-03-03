package cc.tianny.concurrence.thread.method;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/3
 * Time: 9:51 下午
 * Description: 一个线程可以同时拥有多个不同对象的 monitor 对象锁。wait 只释放当前的那把 monitor 锁。
 * Output:
         * ThreadA got resourceA lock.
         * ThreadA got resourceB lock.
         * ThreadA releases resourceA lock.
         * ThreadB got resourceA lock.
         * ThreadB tries to resourceB lock.
 */
public class SeperateMonitorLock {
    // resourceA lock
    private static final Object resourceA = new Object();
    // resourceB lock
    private static final Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("ThreadA got resourceA lock.");
                synchronized (resourceB) {
                    System.out.println("ThreadA got resourceB lock.");
                    try {
                        System.out.println("ThreadA releases resourceA lock.");
                        resourceA.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("ThreadB got resourceA lock.");
                    System.out.println("ThreadB tries to resourceB lock.");

                    synchronized (resourceB) {
                        System.out.println("ThreadB got resourceB lock.");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
