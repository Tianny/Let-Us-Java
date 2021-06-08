package cc.tianny.concurrence.thread.jcip.ch3;

import cc.tianny.concurrence.thread.jcip.annotations.GuardedBy;
import cc.tianny.concurrence.thread.jcip.annotations.ThreadSafe;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 7:21 下午
 * Description: 仅对 set 方法进行同步是不够的，调用 get 的线程仍然会看见失效值
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
