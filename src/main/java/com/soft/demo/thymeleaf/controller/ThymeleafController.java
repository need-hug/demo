package com.soft.demo.thymeleaf.controller;

import com.soft.demo.constans.Constans;
import com.soft.demo.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/** thymeleaf控制器
 * @Auther: lps
 * DateTime: 2019/3/25 17:11
 * @Version: 1.0
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @GetMapping("index")
    public String indexHtml(Model model) {

        User user = new User();
        user.setUserName("Single User userName!");
        user.setPassword("Single User Password!");

        List<User> users = new ArrayList<>();
        getList(users);


        model.addAttribute("user", user);
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/index.ajax")
    @ResponseBody
    public Map<String, Object> index() {
//        Map<String, Object> map = new HashMap<>();
//        Collections.synchronizedMap(map);
//        ConcurrentMap<String, Object> cm = new ConcurrentHashMap<>();
System.out.println(Constans.getTest());
        User user = new User();
        user.setUserName("Single User userName!");
        user.setPassword("Single User Password!");

        List<User> users = new ArrayList<>();
        getList(users);

        Map<String, Object>  model = new HashMap<>();
        model.put("user", user);
        model.put("users", users);
        return model;
    }

    private void getList(List<User> users) {
        for (int i = 30; i < 50; i++) {
            User u = new User();
            u.setUserName(String.format("%03d", i));
            u.setPassword(String.format("%06d", i*100));
            u.setAge(i);
            u.setEdu(i % 2 == 0 ? "大学" : "研究生");

            users.add(u);
        }
    }

    public static void main(String[] args) {
        System.out.println("args = [" + String.format("%06d", 0) + "]");
    }
}
