package cc.tianny.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/14
 * Time: 12:57 下午
 * Description: No Description
 */
public class FileChannelTest {
    public static void main(String[] args) {
        File f = new File("FileChannelTest.java");
        try {
            // 创建 FileInputStream，以该文件输入流创建 FileChannel
            FileChannel inChannel = new FileInputStream(f).getChannel();
            // 以文件输出流创建 FileChannel
            FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
            FileChannel.MapMode mode;
            // 将 FileChannel 里的数据全部映射成 ByteBuffer
            MappedByteBuffer buffer = inChannel.map(MapMode.READ_ONLY, 0, f.length());
            // 使用 GBK 字符集来创建解码器
            Charset charset = Charset.forName("GBK");
            // 直接将 buffer 里的数据全部输出
            outChannel.write(buffer);
            // 再次调用 clear() 方法，复原 limit、position 位置
            buffer.clear();
            // 创建解码器对象
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将 ByteBuffer 转成 CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // CharBuffer 的 toString 方法获取对应的字符串
            System.out.println(charBuffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
