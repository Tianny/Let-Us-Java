package cc.tianny.concurrence.thread.imooc.create;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/24
 * Time: 3:28 下午
 * Description: 继承 Thread 类创建线程
 */
public class ExtendThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("继承 Thread 类创建线程");
    }

    public static void main(String[] args) {
        new ExtendThreadStyle().start();
    }
}
