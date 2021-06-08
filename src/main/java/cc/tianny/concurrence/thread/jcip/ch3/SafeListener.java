package cc.tianny.concurrence.thread.jcip.ch3;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/6
 * Time: 5:42 下午
 * Description: No Description
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = e -> doSomething(e);
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
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

