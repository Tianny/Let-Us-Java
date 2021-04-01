package cc.tianny.concurrence.thread.jcip.ch2;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/1
 * Time: 1:49 下午
 * Description: 先检查后执行，延迟初始化。
 * 包含了竞态条件。
 * 如果有两个线程同时看到instance为空，则会创建两个实例
 */
public class LazyInitRace {
    private ExpensiveObject instance = null;

    private ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

class ExpensiveObject {
}
