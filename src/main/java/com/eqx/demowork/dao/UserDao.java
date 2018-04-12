package com.eqx.demowork.dao;

import com.eqx.demowork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午2:20 2018/4/12
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
