package cc.tianny.concurrence.thread.jcip.ch2;

import cc.tianny.concurrence.thread.jcip.annotations.Recommend;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 2:57 下午
 * Description:  内置锁 synchronized 是可重入的。
 *  如果此时使用的锁不可重入，则会发生死锁
 */
public class NonReentrantDeadlock {
    class Widget {
        public synchronized void doSomething() {
        }
    }

    @Recommend
    class LoggingWidget extends Widget {
        /**
         * 若子类修改父类的行为，则使用内置锁是可被推荐
         */
        @Override
        public synchronized void doSomething() {
            System.out.println(toString() + ": calling doSomething");
            super.doSomething();
        }
    }
}
