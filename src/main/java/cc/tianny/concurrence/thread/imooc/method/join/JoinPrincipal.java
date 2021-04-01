package cc.tianny.concurrence.thread.imooc.method.join;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/7
 * Time: 10:09 下午
 * Description: join 的原理：源码内部会调用 wait。但是没有任何 notify。那么主线程在等待子线程执行完毕后，是如何被唤醒的？
 *              原理：⚠️ C++ 的源码实现：如果直接在 Thread 类或者实例上调用 wait、notify、join 等方法，线程执行完毕退出前会自动在最后执行 notify_all，干扰我们自己设计的唤醒流程。
 * & 代替写法
 */
public class JoinPrincipal {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        System.out.println("开始等待子线程运行完毕");
        thread.join();
        // join 代替写法
        // 主线程直接以 thread 实例为对象锁，拿到锁后，执行 thread.wait()，进入休眠状态。
        // 当子线程执行完毕退出时，会自动调用 notify_all 方法（C++源码），主线程被唤醒，继续执行。
        synchronized (thread) {
            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
