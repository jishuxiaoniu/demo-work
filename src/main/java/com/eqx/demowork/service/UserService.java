package com.eqx.demowork.service;

import com.eqx.demowork.dao.UserDao;
import com.eqx.demowork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午2:57 2018/4/12
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.save(user);
    }
}
