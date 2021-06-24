package cc.tianny.jcip.ch3;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/6
 * Time: 5:03 下午
 * Description:  当 ThisEscape 发布 eventListener 时，也隐含地发布了 ThisEscape 实例本身
 *  因为在这个内部类的实例中包含了对 ThisEscape 实例的隐含引用
 *  ⚠️ 不要在构造过程中使 this 引用溢出
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                // 包含了对 ThisEscape 实例的隐含引用
                doSomething(e);
            }
        });
    }

    void doSomething(Event e) {
    }

    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
