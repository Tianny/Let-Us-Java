package cc.tianny.jcip.ch3;

import cc.tianny.jcip.annotations.Immutable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/7
 * Time: 5:17 下午
 * Description: No Description
 *  从 ThreeStooges 的设计可以看到，虽然 Set 对象是可变的，但在 Set 对象构造完成后，无法对其修改
 *  stooges 是一个 final 类型的引用变量，因此所有对象状态都通过一个 final 域来访问
 *  构造函数能使该引用由除了构造函数及其调用者之外的代码来访问
 */
@Immutable
public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

    public String getStoogeNames() {
        List<String> stooges = new Vector<>();
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
        return stooges.toString();
    }
}
