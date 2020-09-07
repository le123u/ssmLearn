package com.neusoft.dao.Impl;

import com.neusoft.dao.IEmpDao;
import com.neusoft.domain.Emp;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository("empDao")
public class EmpDaoImpl implements IEmpDao {

    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Emp> findAll() {
        try {
            return runner.query("select * from emp",new BeanListHandler<Emp>(Emp.class));
        } catch (SQLException e) {
           throw new RuntimeException(e) ;
        }
    }

    @Override
    public Emp findEmpById(Integer empno) {
        try {
            return runner.query("select * from emp where EMPNO = ?",new BeanHandler<Emp>(Emp.class),empno);
        } catch (SQLException e) {
            throw new RuntimeException(e) ;
        }
    }

    @Override
    public void saveEmp(Emp emp) {
        try {
            runner.update("insert into emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) " +
                    "values (?,?,?,?,?,?,?,?)" ,emp.getEMPNO(),emp.getENAME(),emp.getJOB(),
                    emp.getMGR(), emp.getHIREDATE(),emp.getSAL(),emp.getCOMM(),emp.getDEPTNO());
        } catch (SQLException e) {
            throw new RuntimeException(e) ;
        }
    }

    @Override
    public void updateEmp(Emp emp) {

        try {
            runner.update("update emp set EMPNO=?,ENAME=?,JOB=?,MGR=?,HIREDATE=?,SAL=?,COMM=?,DEPTNO=? where EMPNO = ? " ,emp.getEMPNO(),emp.getENAME(),emp.getJOB(),emp.getMGR(), emp.getHIREDATE(),emp.getSAL(),emp.getCOMM(),emp.getDEPTNO(),emp.getEMPNO());
        } catch (SQLException e) {
            throw new RuntimeException(e) ;
        }

    }

    @Override
    public void deleteEmp(Integer empno) {

        try {
            runner.update("delete from emp where EMPNO = ?" ,empno);
        } catch (SQLException e) {
            throw new RuntimeException(e) ;
        }
    }
}
