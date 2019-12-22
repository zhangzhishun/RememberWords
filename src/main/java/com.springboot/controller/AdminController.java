package com.springboot.controller;

import com.springboot.service.AdminActionService;
import com.springboot.service.AdminLoginService;
import com.springboot.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminLoginService adminLoginServiceImpl;
    @Autowired
    AdminActionService adminActionServiceImpl;
    @Autowired
    UserActionService userActionServiceImpl;

    @GetMapping("")
    public String admin(){
        return "admin/login";
    }

    @GetMapping("adminMain")
    public String adminMain(HttpSession session,Model model){
        /** 将该用户保存的单词展示出来 */
        List<Map<String, Object>> notes = adminActionServiceImpl.getAllNotesAndWords();
        List<Map<String, Object>> users = adminActionServiceImpl.getAllUser();
        for (Map<String,Object> map:users
             ) {
            System.out.println(map);
        }
        model.addAttribute("notes",notes);
        model.addAttribute("users",users);
        return "admin/main";
    }

    @PostMapping("/adminLoginPost")
    public String adminLoginPost(@RequestParam("adminName") String adminName, @RequestParam("adminPassword") String adminPassword,
                            Model model, HttpSession session){
        if(adminLoginServiceImpl.login(adminName,adminPassword)){
            /** 如果登陆成功 */
            session.setAttribute("adminName",adminName);
            return "redirect:adminMain";
        }else{
            //登陆失败
            Map<String, Object> map = new HashMap<>();
            map.put("msg", "用户名密码错误");
            model.addAllAttributes(map);
            return "/admin/login";
        }
    }

    /** 更新密码 */
    @PostMapping("/updateAdminPassword")
    @ResponseBody
    public Integer updateAdminPassword(@RequestParam("prAdminPassword") String prAdminPassword, @RequestParam("newAdminPassword") String newAdminPassword, HttpSession session){
        String adminName = session.getAttribute("adminName").toString();
        Integer re = adminActionServiceImpl.updateAdminPassword(adminActionServiceImpl.getAdminIdByName(adminName), prAdminPassword, newAdminPassword);
        System.out.println(re);
        return re;
    }

    /** 更新用户信息 */
    @PostMapping("/updateUser")
    @ResponseBody
    public Integer updateUser(@RequestParam("updateUserId") String updateUserId, @RequestParam("newUserName") String newUserName,
                                 @RequestParam("newUserPassword") String newUserPassword, @RequestParam("newUserSex") String newUserSex, Model model){
        return adminActionServiceImpl.updateUser(updateUserId, newUserName, newUserPassword, newUserSex);
    }

    /** 管理员上传单词 */
    @PostMapping("/uploadWords")
    @ResponseBody
    public HttpStatus uploadWords(@RequestParam("wordsSpell") String wordsSpell, @RequestParam("wordInterpretation") String wordInterpretation, HttpSession session){
        System.out.println( wordsSpell+wordInterpretation);
        //String userName = session.getAttribute("userName").toString();
        /* id 为-1代表管理员添加的单词 */
        boolean re = userActionServiceImpl.addWordsService("0", wordsSpell, wordInterpretation);
        System.out.println(re);
        return HttpStatus.OK;
    }

    /** 删除指定用户 */
    @GetMapping("delUserByUserId/{userId}")
    public String delNotesById(@PathVariable("userId") String userId,Model model){
        boolean result = adminActionServiceImpl.delUserByUserId(userId);
        model.addAttribute("msg",result?"删除成功":"删除失败");
        return "msg";
    }
}
