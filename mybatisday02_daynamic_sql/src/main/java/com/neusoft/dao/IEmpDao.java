package com.neusoft.dao;

import com.neusoft.domain.Emp;
import com.neusoft.domain.QueryVo;
import com.neusoft.domain.User;

import java.util.List;

public interface IEmpDao {
    // 查询所有
    List<Emp> findAll();

    // 通过empno进行查询
    Emp findByEmpno(int empno);

    // 插入
    int insertEmp(Emp emp);

    // 修改
    int updateEmp(Emp emp);

    // 删除
    int deleteEmp(Integer dept_no);

    // 模糊查询
    List<Emp> likeEmp(String job);

    // 计数
    int countEmp();

    List<Emp> findByCondition(Emp emp);

    List<Emp> findEmpByQueryVo(QueryVo vo);

    List<Emp> findEmpByEmpno(QueryVo vo);
}
