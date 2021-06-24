package cc.tianny.jcip.ch3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/4/6
 * Time: 3:29 下午
 * Description:  当发布某个对象时，可能会间接地发布其他对象。
 * 将一个 secrets 对象添加到集合 knownSecrets 中，因为任何代码都可以遍历这个集合，并获得对这个新 Secret 对象的引用
 */
public class Secrets {
    static Set<Secret> knownSecrets;

    public void initialize() {
        knownSecrets = new HashSet<>();
    }
}

class Secret{}
