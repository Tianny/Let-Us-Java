package cc.tianny.springbootthymeleaf.controller;

import cc.tianny.springbootthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/7
 * Time: 9:05 下午
 * Description: thymeleaf 高级用法
 */
@Controller
public class AdvanceController {
    // inline 内联使用
    @RequestMapping("/inline")
    public String inline(ModelMap map) {
        map.addAttribute("userName", "neo");
        return "inline";
    }

    @RequestMapping("/object")
    public String object(HttpServletRequest request) {
        request.setAttribute("request","i am request");
        request.getSession().setAttribute("session","i am session");
        return "object";
    }

    @RequestMapping("/utility")
    public String utility(ModelMap map) {
        map.addAttribute("userName", "neo");
        map.addAttribute("users", getUserList());
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "utility";
    }

    private List<User> getUserList(){
        List<User> list= new ArrayList<>();
        User user1=new User("大牛",12,"123456");
        User user2=new User("小牛",6,"123563");
        User user3=new User("Tianny",66,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }
}
