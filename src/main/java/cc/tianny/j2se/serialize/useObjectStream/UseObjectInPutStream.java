package cc.tianny.j2se.serialize.useObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/11
 * Time: 12:18 下午
 * Description: No Description
 */
public class UseObjectInPutStream {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Person p = (Person)ois.readObject();
            System.out.println(p.getName());
            System.out.println(p.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
