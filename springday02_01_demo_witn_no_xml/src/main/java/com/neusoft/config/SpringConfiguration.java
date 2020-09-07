package com.neusoft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//Spring全注解配置
//ComponentScan作用 ：导包 指定spring创建容器时要扫的包
// 属性 :value 和 basePackages一样 指定要导的包
/**
 * // 等价于xml中配置
 * 告知spring在创建容器的时候要扫的包
 *  <context:component-scan base-package="com.neusoft">
 *
 *     </context:component-scan>
 */


// Bean的作用：把当前方法的返回值作为bean对象，存入spring的ioc容器中
    // 属性 name 指定bean的id 不写时是当前方法名
    // 细节 当我们使用注解配置时 如果说方法有参数 spring框架去容器中查找有没有
    // 可用的bean对象 查找的方式和Auto注解的作用是一样的

// Import 导入配置类
    // 属性 配置类的字节码文件
    // 当我们使用import注解之后 import注解的类就是（SpringConfiguration）就是父类配置
    // 而导入的都是子类配置（JdbcConfig）

// PropertySource
// 指定文件的位置
// 属性 是文件的名称和路径 class path 表示类路径

//@ComponentScan({"com.neusoft"})
//@ComponentScan(basePackages = "com.neusoft")
@ComponentScan("com.neusoft")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
