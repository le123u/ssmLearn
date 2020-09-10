package com.neusoft.controller;

import com.neusoft.domain.Account;
import com.neusoft.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有账户");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list11";
    }

    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("表现层插入账户");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

    @RequestMapping("/updateAccount")
    public void updateAccount(Account account, HttpServletResponse response, HttpServletRequest request) throws Exception {
        accountService.updateAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }

    @RequestMapping("/deleteAccount")
    public void deleteAccount(Integer id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        accountService.deleteAccount(id);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }



}
