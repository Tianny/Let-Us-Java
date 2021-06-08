package cc.tianny.concurrence.thread.jcip.ch3;

import cc.tianny.concurrence.thread.jcip.annotations.NotThreadSafe;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 7:20 下午
 * Description: 如果某个线程调用了set，那么另一个正在调用 get 的线程。可能会看到更新后的 value 值，也可能看不到。
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}