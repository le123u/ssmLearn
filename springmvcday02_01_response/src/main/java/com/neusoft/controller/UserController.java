package com.neusoft.controller;

import com.neusoft.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    // string响应
    @RequestMapping("/testString")
       public String testString(Model model){
        User user = new User();
        // 假设这是调用service查出的结果
        user.setUsername("真好看");
        user.setPassword("123");
        user.setAge(22);
        // model 对象会存储在request中
        model.addAttribute("user",user);
        return "success";
    }

    // void响应
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("testVoid");
        // 请求转发去响应
//      request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        // response.sendRedirect(request.getContextPath()+"/index.jsp");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("hello");
        return;
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("aaaaaa");
        user.setPassword("123");
        user.setAge(22);
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testFOR")
    public String testFOR(){
        System.out.println("testFOR");
        return "redirect:/success.jsp";
    }
}
