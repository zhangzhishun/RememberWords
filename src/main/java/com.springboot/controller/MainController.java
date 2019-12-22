package com.springboot.controller;

import com.springboot.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller

public class MainController {

    @Autowired
    UserActionService userActionServiceImpl;

    /** 进入main页面 */
    @GetMapping("/main")
    public String main(HttpSession session,Model model){
        String userName = session.getAttribute("userName").toString();
        /** 将该用户保存的单词展示出来 */
        List<Map<String, Object>> notes = userActionServiceImpl.getNotesAndWordsByUserId(userActionServiceImpl.getUserIdByName(userName));
        for (Map<String,Object>map:notes
             ) {
            System.out.println(map);
        }
        model.addAttribute("notes",notes);
        return "main";
    }

    /** 上传单词 */
    @PostMapping("/uploadWords")
    @ResponseBody
    public HttpStatus uploadWords(@RequestParam("wordsSpell") String wordsSpell, @RequestParam("wordInterpretation") String wordInterpretation, HttpSession session){
        System.out.println( wordsSpell+wordInterpretation);
        String userName = session.getAttribute("userName").toString();
        boolean re = userActionServiceImpl.addWordsService(userActionServiceImpl.getUserIdByName(userName), wordsSpell, wordInterpretation);
        System.out.println(re);
        return HttpStatus.OK;
    }

    /** 更新密码 */
    @PostMapping("/updateUserPassword")
    @ResponseBody
    public Integer updateUserPassword(@RequestParam("prUserPassword") String prUserPassword, @RequestParam("newUserPassword") String newUserPassword, HttpSession session){
        System.out.println( prUserPassword+newUserPassword);
        String userName = session.getAttribute("userName").toString();
        Integer re = userActionServiceImpl.updateUserPassword(userActionServiceImpl.getUserIdByName(userName), prUserPassword, newUserPassword);
        System.out.println(re);
        return re;
    }

    /** 更新单词 -- weiwancheng */
    @PostMapping("/updateWords")
    @ResponseBody
    public HttpStatus updateWords(@RequestParam("wordsId") String wordsId, @RequestParam("wordsSpell") String wordsSpell,
                               @RequestParam("wordInterpretation") String wordInterpretation, HttpSession session){
        System.out.println( wordsId+wordsSpell+wordInterpretation);
        String userName = session.getAttribute("userName").toString();
        Boolean re = userActionServiceImpl.updateWords(wordsId,wordsSpell,wordInterpretation);
        System.out.println(re);
        if(re){
            return HttpStatus.OK;
        }else{
            return HttpStatus.BAD_REQUEST;
        }
    }

    /** 删除指定单词 */
    @GetMapping("delWordsByWordsId/{wordsId}")
    public String delNotesById(@PathVariable("wordsId") String wordsId,Model model){
        boolean result = userActionServiceImpl.delNotesAndWordsByWordsId(wordsId);
        model.addAttribute("msg",result);
        return "msg";
    }
}
