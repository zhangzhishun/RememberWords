package com.springboot.controller;

import com.springboot.service.UserActionService;
import com.springboot.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
public class LoginController {


    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @Autowired
    UserLoginService userLoginServiceImpl;
    @Autowired
    UserActionService userActionServiceImpl;

    @PostMapping("/loginPost")
    public String loginPost(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,
                            Model model, HttpSession session){
        if(userLoginServiceImpl.login(userName,userPassword)){
            /** 如果登陆成功 */
            session.setAttribute("userName",userName);
            return "redirect:main";
        }else{
            //登陆失败
            Map<String, Object> map = new HashMap<>();
            map.put("msg", "用户名密码错误");
            model.addAllAttributes(map);
            return "login";
        }

    }
}
