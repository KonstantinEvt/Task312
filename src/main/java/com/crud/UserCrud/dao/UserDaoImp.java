package com.crud.UserCrud.dao;

import com.crud.UserCrud.model.UserCrud;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(UserCrud userCrud) {
        entityManager.persist(userCrud);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(entityManager.find(UserCrud.class, id));
    }

    @Override
    public UserCrud getUser(Long id) {
        return entityManager.find(UserCrud.class, id);
    }

    @Override
    public List<UserCrud> getListUsers() {
        return entityManager.createQuery("from UserCrud", UserCrud.class).getResultList();
    }

    @Override
    public void updateUser(UserCrud userCrud, Long id) {
        UserCrud userOld = entityManager.find(UserCrud.class, id);
        userOld.setFirstName(userCrud.getFirstName());
        userOld.setLastName(userCrud.getLastName());
        userOld.setEmail(userCrud.getEmail());
    }

}
