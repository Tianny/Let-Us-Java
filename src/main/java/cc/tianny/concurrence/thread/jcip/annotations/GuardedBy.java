package cc.tianny.concurrence.thread.jcip.annotations;

/**
 * 摘录自原文： @GuardedBy(lock) 表示只有在持有了某个特定的锁时才能访问这个域或方法。
 * 参数 lock 表示在访问被标注的域或方法时需要持有的锁。
 * 通过 @GuardedBy 来标识每个需要加锁的状态变最以及保护该变量的锁，能够有助于代码
 * 的维护与审查，以及通过一些自动化的分析工具找出潜在的钱程安全性错误。
 * create by Tianny
 */
public @interface GuardedBy {
    /**
     * 以下为 lock 可能的取值（摘录自原文）
     * • @GuardedBy("this")，表示在包含对象上的内置锁（被标注的方法或域是该对象的成员)。
     * • @GuardedBy("fieldName") 表示与fieldName 引用的对象相关联的锁，可以是一个隐式锁（对于不引用一个 Lock 的域），也可以是一个显式锁（对于引用了一个Lock 的域）。
     * • @GuardedBy("Class Name.fieldName"), 类似于 @GuardedBy("fieldName")，但指向在另一个类的静态域中持有的锁对象。
     * • @GuardedBy("methodName()")，是指通过调用命名方法返回的锁封象。
     * • @GuardedBy("ClassName.class")，是指命名类的类自变量对象。
     * @return
     */
    String value() default "";
}
