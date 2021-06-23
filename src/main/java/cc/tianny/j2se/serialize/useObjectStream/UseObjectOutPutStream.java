package cc.tianny.j2se.serialize.useObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/11
 * Time: 12:16 下午
 * Description: No Description
 */
public class UseObjectOutPutStream {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            Person p = new Person("monkeyKing", 500);
            oos.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
