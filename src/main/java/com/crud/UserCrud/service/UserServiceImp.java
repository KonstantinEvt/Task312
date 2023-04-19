package com.crud.UserCrud.service;


import com.crud.UserCrud.dao.UserDao;
import com.crud.UserCrud.model.UserCrud;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(UserCrud userCrud) {
        userDao.addUser(userCrud);
    }

    @Transactional(readOnly = true)
    @Override
    public UserCrud getUser(Long id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserCrud> getListUsers() {
        return userDao.getListUsers();
    }

    @Transactional
    @Override
    public void updateUser(UserCrud userCrud, Long id) {
         userDao.updateUser(userCrud,id);
    }


}
