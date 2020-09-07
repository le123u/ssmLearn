package com.neusoft.test;

import com.neusoft.domain.Emp;
import com.neusoft.service.IAccountService;
import com.neusoft.service.IEmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class TestEmp {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");;
    private IEmpService as = ac.getBean("empService", IEmpService.class);;

    @Test
    public void testFindAll(){
        List<Emp> allEmp = as.findAllEmp();
        for(Emp l : allEmp){
            System.out.println(l);
        }
    }

    @Test
    public void testFinfById(){
        Emp emp = as.findEmpById(7369);
        System.out.println(emp);
    }

    @Test
    public void testSaveEmp(){
        Emp emp = new Emp();
        emp.setEMPNO(9998);
        emp.setENAME("aaa");
        emp.setJOB("haha");
        emp.setMGR(7788);
        emp.setHIREDATE(new Date());
        emp.setSAL(9999);
        emp.setCOMM(200);
        emp.setDEPTNO(50);
        as.saveEmp(emp);
    }

    @Test
    public void testUpdateEmp(){
        Emp emp = new Emp();
        emp.setEMPNO(9001);
        emp.setENAME("aaa");
        emp.setJOB("haha");
        emp.setMGR(7788);
        emp.setHIREDATE(new Date());
        emp.setSAL(9999);
        emp.setCOMM(200);
        emp.setDEPTNO(50);
        as.updateEmp(emp);
    }

    @Test
    public void testDeleteEmp(){
        as.deleteEmp(9001);
    }
}
