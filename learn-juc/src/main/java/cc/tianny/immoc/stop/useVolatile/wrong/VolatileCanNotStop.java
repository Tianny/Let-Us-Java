package cc.tianny.immoc.stop.useVolatile.wrong;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/26
 * Time: 3:30 下午
 * Description: ⚠️ volatile 不能唤醒已经阻塞的线程
 *              目的：通过阻塞队列生产者消费者模式演示 volatile 的局限性。
 *              场景描述：生产者生产速度较快，消费者消费速度较慢。通过阻塞队列存储商品。
 *              背景知识：阻塞队列在队列满之后，线程无法继续往队列中添加新的元素，线程处于阻塞状态
 */
public class VolatileCanNotStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        // 等待 1s 足够让生产者把阻塞队列塞满
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(storage.take() + " 被消费");
            // 让消费者消费慢一点，给生产者生产的时间
            Thread.sleep(100);
        }

        System.out.println("消费者消费完毕");
        // 消费者消费完毕，此处让生产者停止生产（实际情况并不能生效，因为此时生产者处于阻塞状态，volatile 不能唤醒阻塞状态的线程）
        producer.canceled = true;

    }
}


class Producer implements Runnable {

    // 设置 volatile 修饰的关键字
    public volatile boolean canceled = false;

    private BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            // 通过 canceled 标识判断
            while (num < Integer.MAX_VALUE / 2 && !canceled) {
                if (num % 100 == 0) {
                    // 当消费者线程不再消费，导致阻塞队列满了之后，生产者线程将被阻塞在这里，无法继续执行后续的代码。
                    // 也就无法走到 while 循环条件的 canceled 判断
                    this.storage.put(num);
                    System.out.println(num + "是 100 的倍数，已经被放入仓库");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 无法执行到该语句
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
        return Math.random() < 0.95;
    }
}