package cc.tianny.concurrence.thread.jcip.annotations;

/**
 * 被该注解标注的类不可变，包含了@ThreadSafe注解
 * create by yifeng
 */
@ThreadSafe
public @interface Immutable {
    String value() default "";
}
