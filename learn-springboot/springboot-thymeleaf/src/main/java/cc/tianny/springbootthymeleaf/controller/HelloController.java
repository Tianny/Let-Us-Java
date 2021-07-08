package cc.tianny.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/7/7
 * Time: 9:05 下午
 * Description: No Description
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "https://tianny.cc");
        return "hello";
    }
}
