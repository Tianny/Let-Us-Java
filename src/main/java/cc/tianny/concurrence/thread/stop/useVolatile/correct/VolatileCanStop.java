package cc.tianny.concurrence.thread.stop.useVolatile.correct;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/26
 * Time: 4:01 下午
 * Description: 针对 VolatileCanNotStop 的问题，直接使用 interrupt() 方法
 */
public class VolatileCanStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(storage.take() + "被消费");
            Thread.sleep(100);
        }

        System.out.println("消费者消费完毕");
        // 调用 interrupt 方法
        producerThread.interrupt();
    }
}


class Producer implements Runnable {

    private BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            // 判断线程终止状态标志位
            while (num < Integer.MAX_VALUE / 2 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    this.storage.put(num);
                    System.out.println(num + "是100的倍数，已经被放入仓库");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者停止生产");
        }
    }
}

class Consumer {
    private BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        return Math.random() < 0.95 ? true : false;
    }
}