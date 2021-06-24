package cc.tianny.serialize.conferenceSerialize;

import cc.tianny.serialize.useObjectStream.Person;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/6/11
 * Time: 5:58 下午
 * Description: No Description
 */
public class Teacher implements java.io.Serializable {
    private String name;
    private Person student;

    public Teacher(String name, Person student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public static void main(String[] args) {
        Person p = new Person("monkeyKing", 500);
        Teacher t1 = new Teacher("ruLai", p);
        Teacher t2 = new Teacher("sanZan", p);
    }
}
