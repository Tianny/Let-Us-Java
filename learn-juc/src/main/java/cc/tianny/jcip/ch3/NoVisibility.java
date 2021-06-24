package cc.tianny.jcip.ch3;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 7:14 下午
 * Description: 失效数据。因在代码中没有使用足够的同步机制。
 * 当读线程查看 ready 变量时，可能会得到一个失效的值。
 * 更糟糕的是，失效值可能不会同时出现：一个线程可能获得某个变量的最新值，而获得另一个变量的失效值。
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready)
                Thread.yield();
            // 这里看起来会输出 42，但事实可能输出 0，或者无法终止
            System.out.println(number);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        // 模拟，如果主线程执行慢了，则 ReaderThread 将不会停止
        Thread.currentThread().wait(1000);
        number = 42;
        ready = true;
    }
}