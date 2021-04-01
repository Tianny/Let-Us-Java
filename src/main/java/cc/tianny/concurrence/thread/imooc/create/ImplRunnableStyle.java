package cc.tianny.concurrence.thread.imooc.create;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/24
 * Time: 3:31 下午
 * Description: 实现 Runnable 接口创建线程
 */
public class ImplRunnableStyle implements Runnable{
    @Override
    public void run() {
        System.out.println("实现 Runnable 接口创建线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ImplRunnableStyle());
        thread.start();
    }
}
