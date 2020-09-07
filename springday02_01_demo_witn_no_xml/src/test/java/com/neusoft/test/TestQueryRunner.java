package com.neusoft.test;

import com.neusoft.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestQueryRunner {

    @Test
    public void testRunner(){
        // 获取容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 获取queryrunner对象
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);

    }
}
