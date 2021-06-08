package cc.tianny.concurrence.thread.jcip.ch3;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/2
 * Time: 10:17 上午
 * Description: No Description
 * 当且仅当满足以下所有条件时，才应该使用 volatile 变量：
 * 对变量的写入操作不依赖变量的当前值，或者你能确保只有单个线程更新变量的值
 * 该变量不会与其他状态变量一起纳入不变性条件中
 * 在访问变量时不需要加锁
 */
public class CountingSheep {

    volatile boolean asleep;

    void tryToSleep() {
        // 该 volatile 的语义不足以确保递增操作的原子性
        // 如不能确保 countSomeSeep 的原子性
        while (!asleep)
            countSomeSeep();
    }

    void countSomeSeep() {
        // One, two , three..
    }

}
