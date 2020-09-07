package com.neusoft.test;

import com.neusoft.domain.Account;
import com.neusoft.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


public class TestDao {


    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");;
    private IAccountService as = ac.getBean("accountService", IAccountService.class);;

    @Test
    public void testFindAll(){

        List<Account> allAccount = as.findAllAccount();
        for(Account a : allAccount){
            System.out.println(a);
        }
    }

    @Test
    public void testFindById(){
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setName("aaaaaaa");
        account.setMoney(2000F);
        as.saveAccount(account);
    }

    @Test
    public void testUpdateAccount(){
        Account account = new Account();
        account.setId(1);
        account.setName("ddddd");
        account.setMoney(10000F);
        as.updateAccount(account);
    }

    @Test
    public void testDeleteAccount(){
        as.deleteAccount(4);
    }
}
