package cc.tianny.concurrence.j2se.nio;

import java.nio.CharBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/14
 * Time: 10:16 上午
 * Description: No Description
 */
public class BufferTest {
    public static void main(String[] args) {
        // 创建 Buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity: " + buff.capacity());
        System.out.println("limit: " + buff.limit());
        System.out.println("position: " + buff.position());
        // 放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入三个元素后，position= " + buff.position());
        // 调用 flip() 方法
        buff.flip();
        System.out.println("执行 flip() 方法后，limit=" + buff.position());
        System.out.println("执行 flip() 方法后，position=" + buff.position());
        // 取出第一个元素
        System.out.println("第一个元素(position=0): " + buff.get());
        System.out.println("取出第一个元素后，position=" + buff.position());
        // 调用 clear() 方法
        System.out.println("执行 clear() 方法后，limit=" + buff.limit());
        System.out.println("执行 clear() 后，position=" + buff.position());
        System.out.println("执行 clear() 后，缓冲区内容没有被清除：" + "第三个元素为 " + buff.get(2));
        System.out.println("执行绝对读取后，position=" + buff.position());
    }
}
