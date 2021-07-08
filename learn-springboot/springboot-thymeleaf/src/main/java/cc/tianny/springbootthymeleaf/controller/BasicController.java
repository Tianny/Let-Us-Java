package cc.tianny.springbootthymeleaf.controller;

import cc.tianny.springbootthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/7
 * Time: 9:05 下午
 * Description: thymeleaf 基本用法
 */
@Controller
public class BasicController {
    // 赋值、字符串拼接
    @RequestMapping("/string")
    public String index(ModelMap map) {
        map.addAttribute("userName", "Tianny");
        return "string";
    }

    // if 判断
    @RequestMapping("/if")
    public String ifUnless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    // for 循环列表
    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    // 外链
    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "spring/2017/09/11/");
        return "url";
    }

    // 判断
    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "neo");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    // switch
    @RequestMapping("/switch")
    public String switchCase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }

    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        User user1 = new User("大牛", 12, "123456");
        User user2 = new User("小牛", 6, "123563");
        User user3 = new User("Tianny", 66, "666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
