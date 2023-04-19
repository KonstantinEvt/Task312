package com.crud.UserCrud.dao;


import com.crud.UserCrud.model.UserCrud;

import java.util.List;

public interface UserDao {
    void addUser(UserCrud user);
    void removeUser(Long id);
    UserCrud getUser(Long id);

    List<UserCrud> getListUsers();
    void updateUser(UserCrud userCrud, Long id);

}
