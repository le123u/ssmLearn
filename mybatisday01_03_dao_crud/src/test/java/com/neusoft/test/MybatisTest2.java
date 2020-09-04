package com.neusoft.test;

import com.neusoft.dao.IEmpDao;
import com.neusoft.dao.IUserDao;
import com.neusoft.domain.Emp;
import com.neusoft.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest2 {
    private InputStream in;
    private SqlSession sqlSession;
    private IEmpDao empDao;

    // 在测试方法之前执行
    @Before
    public void init() throws IOException {
        // 1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建 SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用 工厂生产的 SqlSession对象
        sqlSession = factory.openSession();
        // 4. 使用SqlSession 创建Dao 接口 的代理对象
        empDao = sqlSession.getMapper(IEmpDao.class);
    }

    @After
    public void destroy() throws IOException {
        // 提交事物
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAllTest(){
        List<Emp> emps = empDao.findAll();
        for(Emp emp:emps){
            System.out.println(emp);
        }
    }

    @Test
    public void findByEmpnoTest(){
        Emp empno = empDao.findByEmpno(7499);
        System.out.println(empno);
    }

    @Test
    public void insertEmpTest(){
        Emp emp = new Emp();
        emp.setEMPNO(9999);
        emp.setENAME("dongdong");
        emp.setJOB("Java");
        emp.setMGR(7654);
        emp.setHIREDATE(new Date());
        emp.setSAL(6500);
        emp.setCOMM(10000);
        emp.setDEPTNO(20);
        int i = empDao.insertEmp(emp);
        System.out.println(i);
        System.out.println(emp.getEMPNO());
    }

    @Test
    public void updateEmpTest(){
        Emp emp = new Emp();
        emp.setEMPNO(8888);
        emp.setENAME("dongdong");
        emp.setJOB("Java");
        emp.setMGR(7654);
        emp.setHIREDATE(new Date());
        emp.setSAL(6500);
        emp.setCOMM(10000);
        emp.setDEPTNO(20);
        empDao.updateEmp(emp);
    }

    @Test
    public void deleteEmpTest() {

        int emp = empDao.deleteEmp(9999);
        System.out.println("emp"+emp);
    }

    @Test
    public void findLikeTest() {
        List<Emp> empee = empDao.findByEname("%A%");
        for(Emp empe : empee){
            System.out.println(empe);
        }
    }

    @Test
    public void findCountTest() {
        int count = empDao.findCount();
        System.out.println(count);
    }
}