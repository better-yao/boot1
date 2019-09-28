package com.yao.boot1.controller;

import com.yao.boot1.entity.toolEntity;
import com.yao.boot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST )
    @ResponseBody
    public toolEntity findUser(String username, String password ,HttpServletRequest request){

        Integer userlogin = userService.findUser(username, password);
        System.out.println("测试3");
        System.out.println(userlogin);
        toolEntity mes = new toolEntity();
        if(username != null && password != null && userlogin == 1) {
            mes.setMessage("登陆成功");
            request.getSession().setAttribute("userMessage",username);
            System.out.println(request.getSession().getAttribute("userMessage")+"测试4");
            return mes;
        }else {
            mes.setMessage("登陆失败！");
            return mes;
        }
    }
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("userMessage");
        return "login";
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request){
        System.out.println("测试5");
        return "test";
    }

}
