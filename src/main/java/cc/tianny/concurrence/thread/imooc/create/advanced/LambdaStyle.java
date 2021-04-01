package cc.tianny.concurrence.thread.imooc.create.advanced;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/24
 * Time: 3:41 下午
 * Description: lambda 表达式创建线程
 */
public class LambdaStyle {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
