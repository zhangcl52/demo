package com.hunter.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by homelink on 2016/5/24.
 */
@Controller
@RequestMapping(value = "/demoTest")
public class testController {
    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request, ModelAndView model) {
        System.out.println("zhangcl");
        return "test/register";
    }

    @RequestMapping(value = "/testAdd")
    public String testAdd(HttpServletRequest request, ModelAndView model) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);
        return "test/register";
    }
}
