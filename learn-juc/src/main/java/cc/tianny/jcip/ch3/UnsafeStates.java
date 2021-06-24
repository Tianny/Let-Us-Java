package cc.tianny.jcip.ch3;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/6
 * Time: 4:58 下午
 * Description: 从非私有方法返回一个引用
 * 任何一个调用者都会修改这个数组的内容
 */
public class UnsafeStates {
    private String[] states = new String[]{
            "AL", "AK", "..."
    };

    public String[] getStates() {
        return states;
    }
}

