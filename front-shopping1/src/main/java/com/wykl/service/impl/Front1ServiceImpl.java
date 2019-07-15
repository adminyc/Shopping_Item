package com.wykl.service.impl;

import com.wykl.dao.Front1Dao;
import com.wykl.pojo.Users;
import com.wykl.service.Front1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Front1ServiceImpl implements Front1Service {
    @Autowired
    private Front1Dao fd1;
    @Override
    public Users wykl_login(Users users) {
        return fd1.loginkl(users);
    }
}
