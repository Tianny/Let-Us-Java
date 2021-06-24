package cc.tianny.immoc.method.waitNotify;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/3
 * Time: 5:13 下午
 * Description: wait & notify 基本用法
 * Output:
 *        Thread-0 开始执行了
 *        Thread-1 调用了 notify()
 *        Thread-0 获取到了锁
 */
public class WaitNotify {
    // 对象锁
    public static final Object object = new Object();

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + " 开始执行了");
                try {
                    // 线程进入阻塞状态；并释放 monitor 锁
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 获取到了锁");
            }

        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                // notify、notifyAll 并不释放锁
                // 只是告诉调用过 wait 方法的线程可以去参与获得锁的竞争了
                // ⚠️ 必须等到 synchronized 语法块执行完才真正释放锁
                object.notify();
                System.out.println(Thread.currentThread().getName() + " 调用了 notify()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread1();
        thread1.start();
        Thread.sleep(200);
        Thread thread2 = new Thread2();
        thread2.start();
    }
}
