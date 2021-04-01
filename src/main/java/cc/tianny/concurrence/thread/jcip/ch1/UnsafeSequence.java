package cc.tianny.concurrence.thread.jcip.ch1;

import cc.tianny.concurrence.thread.jcip.annotations.NotThreadSafe;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 10:56 上午
 * Description: 竞态条件。如果执行时机不到，那么两个线程交替执行 getNext 时会得到
 * 相同的值。
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public int getNext() {
        return value++;
    }
}
