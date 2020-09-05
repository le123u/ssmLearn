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
    public void testFindAll(){
        List<Emp> emps = empDao.findAll();
        for (Emp emp : emps){
            System.out.println(emp);
        }
    }

    @Test
    public void testFindByEmpno(){
        Emp byEmpno = empDao.findByEmpno(7369);
        System.out.println(byEmpno);
    }

    @Test
    public void testInsertEmp(){
        Emp emp = new Emp();
        emp.setEmp_no(9001);
        emp.setE_name("liu");
        emp.setE_job("python");
        emp.setMgr(6666);
        emp.setHirdate(new Date());
        emp.setSal(8899);
        emp.setComm(100);
        emp.setDept_no(30);
        int i = empDao.insertEmp(emp);
        System.out.println(i);

    }
    @Test
    public void testUpdateEmp(){
        Emp emp = new Emp();
        emp.setEmp_no(7934);
        emp.setE_name("liu");
        emp.setE_job("python");
        emp.setMgr(6666);
        emp.setHirdate(new Date());
        emp.setSal(8899);
        emp.setComm(100);
        emp.setDept_no(30);
        int i = empDao.updateEmp(emp);
        System.out.println(i);

    }

    @Test
    public void testDeleteEmp(){
        int i = empDao.deleteEmp(8899);
        System.out.println(i);
    }

    @Test
    public void testLikeEmp(){
        List<Emp> emps = empDao.likeEmp("C");
        for(Emp emp:emps){
            System.out.println(emp);
        }
    }

    @Test
    public void testCountEmp(){
        int i = empDao.countEmp();
        System.out.println(i);
    }



}
