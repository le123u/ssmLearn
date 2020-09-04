package com.neusoft.dao;

import com.neusoft.domain.Emp;

import java.util.List;

public interface IEmpDao {
    // 查询所有
    List<Emp> findAll();

    // 通过empno进行查询
    Emp findByEmpno(int EMPNO);

    /**
     * 插入用户
     */
    int insertEmp(Emp emp);

    // 修改
    int updateEmp(Emp emp);

    // 删除
    int deleteEmp(int EMPNO);

    // like
    List<Emp> findByEname(String ename);

    //  查询总记录数
    int findCount();
}
