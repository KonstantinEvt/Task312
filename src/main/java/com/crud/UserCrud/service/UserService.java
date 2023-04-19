package com.crud.UserCrud.service;



import com.crud.UserCrud.model.UserCrud;

import java.util.List;

public interface UserService {
    void addUser(UserCrud userCrud);
    UserCrud getUser(Long id);

    void removeUser(Long id) ;

    List<UserCrud> getListUsers();
    void updateUser(UserCrud userCrud, Long id);



}
