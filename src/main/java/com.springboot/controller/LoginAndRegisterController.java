package com.springboot.controller;

import com.springboot.service.UserActionService;
import com.springboot.service.UserLoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
public class LoginAndRegisterController {

    @Autowired
    UserLoginAndRegisterService userLoginAndRegisterServiceImpl;
    @Autowired
    UserActionService userActionServiceImpl;

    @GetMapping("/login")
    public String loginGet(){
        return "user/login";
    }

    @PostMapping("/loginPost")
    public String loginPost(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,
                            Model model, HttpSession session){
        if(userLoginAndRegisterServiceImpl.login(userName,userPassword)){
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

    @PostMapping("/userRegister")
    public String userRegister(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,
                               @RequestParam("userSex") String userSex,Model model){
        Integer result = userLoginAndRegisterServiceImpl.userRegister(userName, userPassword, userSex.equals("请选择性别")?null:userSex);
        if(result == -1){
            model.addAttribute("msg","用户名不可用，请更换用户名");
        }else if(result == 0){
            model.addAttribute("msg","网络异常");
        }else if(result == 1){
            model.addAttribute("msg","注册成功");
        }
        return "msg";
    }
}
