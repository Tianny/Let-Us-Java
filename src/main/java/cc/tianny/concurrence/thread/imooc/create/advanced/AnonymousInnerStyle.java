package cc.tianny.concurrence.thread.imooc.create.advanced;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/2/24
 * Time: 3:43 下午
 * Description: 匿名内部类方式创建
 */
public class AnonymousInnerStyle {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }


}
