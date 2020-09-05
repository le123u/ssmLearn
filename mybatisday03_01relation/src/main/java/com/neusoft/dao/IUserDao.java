package com.neusoft.dao;

import com.neusoft.domain.QueryVo;
import com.neusoft.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    // 查询所有
    List<User> findAll();
    /**
     * 根据id查询
     */
    User findById(Integer id);

    /**
     * 保存用户 返回插入的id 在user里 user.getId()
     */
    int saveUser(User user);

    /**
     * 更新用户
     */
    int updateUser(User user);

    /**
     * 删除用户
     */

    int deleteUser(Integer id);

    /**
     * 根据姓名进行模糊查询
     */

    List<User> findByName(String username);

    /**
     * 查询总记录数
     */
    int findTotal();

    // 根据传参条件进行查询 有可能是用户名。。。。
    List<User> findByCondition(User user);

    // 有时候传入其他实体类类型
    List<User> findUserByQueryVo(QueryVo vo);

    // 根据id集合进行用户查询
    List<User> findUserByIds(QueryVo vo);
}