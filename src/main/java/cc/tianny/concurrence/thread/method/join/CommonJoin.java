package cc.tianny.concurrence.thread.method.join;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/3/7
 * Time: 2:59 下午
 * Description: join 基本用法
 *              新的线程加入了我们，所以我们要等待新加入的线程执行完毕再出发
 *              例子中 main 线程等待子线程执行完毕才会继续执行
 */
public class CommonJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
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
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        thread2.start();
        System.out.println("开始等待子线程执行完毕");
        // thread 和 thread2 join 到 main 主线程，
        // 所以主线程需要等到 thread 和 thread2 执行完，才能继续执行
        thread.join();
        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
