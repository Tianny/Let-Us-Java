package cc.tianny.j2se.serialize.custom;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/14
 * Time: 8:03 上午
 * Description: No Description
 */
public class CustomSerialize implements Serializable {
    private String name;
    private int age;

    public CustomSerialize(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        // 将 name 实例变量值反转后写入二进制流
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
}
