package com.neusoft.domain;

import java.util.List;

public class QueryVo {

    private User user;

    private Emp emp;

    private List<Integer> ids;

    private List<Integer> empnos;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<Integer> getEmpnos() {
        return empnos;
    }

    public void setEmpnos(List<Integer> empnos) {
        this.empnos = empnos;
    }
}
