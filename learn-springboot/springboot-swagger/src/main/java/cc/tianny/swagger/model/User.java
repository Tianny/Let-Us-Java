package cc.tianny.swagger.model;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/13
 * Time: 7:05 上午
 * Description: No Description
 */

public class User {
    private Long id;
    private String name;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

