package com.neusoft.service.Impl;

import com.neusoft.dao.IEmpDao;
import com.neusoft.domain.Emp;
import com.neusoft.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("empService")
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private IEmpDao empDao;

    @Override
    public List<Emp> findAllEmp() {
        return empDao.findAll();
    }

    @Override
    public Emp findEmpById(Integer empno) {
        return empDao.findEmpById(empno);
    }

    @Override
    public void saveEmp(Emp emp) {
        empDao.saveEmp(emp);

    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);

    }

    @Override
    public void deleteEmp(Integer empno) {
        empDao.deleteEmp(empno);
    }
}
