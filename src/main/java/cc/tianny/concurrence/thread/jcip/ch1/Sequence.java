package cc.tianny.concurrence.thread.jcip.ch1;

import cc.tianny.concurrence.thread.jcip.annotations.GuardedBy;
import cc.tianny.concurrence.thread.jcip.annotations.ThreadSafe;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 10:55 上午
 * Description: 通过将 getNext 修改为一个同步方法，可以修复 UnsafeSequence 中的错误
 */
@ThreadSafe
public class Sequence {
    @GuardedBy("this")
    private int Value;

    public  synchronized int getNext() {
        return Value++;
    }
}
