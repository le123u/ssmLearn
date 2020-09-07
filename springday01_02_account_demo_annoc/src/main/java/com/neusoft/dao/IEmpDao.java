package com.neusoft.dao;

import com.neusoft.domain.Account;
import com.neusoft.domain.Emp;

import java.util.List;

public interface IEmpDao {

    List<Emp> findAll() ;

    Emp findEmpById(Integer empno);

    void saveEmp(Emp emp);

    void updateEmp(Emp emp);

    void deleteEmp(Integer empno);
}
