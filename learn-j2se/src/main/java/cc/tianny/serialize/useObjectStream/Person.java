package cc.tianny.serialize.useObjectStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/11
 * Time: 12:16 下午
 * Description: No Description
 */

public class Person implements java.io.Serializable {
    private String name;
    private int age;

    // 注意此处没有提供无参的构造器，而是提供了有参的构造器
    public Person(String name, int age) {
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
}