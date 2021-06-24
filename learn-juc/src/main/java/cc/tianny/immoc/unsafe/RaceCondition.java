package cc.tianny.immoc.unsafe;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 6:21 上午
 * Description: 竞态条件代码演示, a++ 问题.
 */
public class RaceCondition implements Runnable {
    static RaceCondition raceCondition = new RaceCondition();
    int index = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(raceCondition);
        Thread thread2 = new Thread(raceCondition);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("index 值为: " + raceCondition.index);
    }
}
