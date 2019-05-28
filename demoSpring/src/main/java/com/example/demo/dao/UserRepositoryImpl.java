package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager em;

    @Override
    public User findUserByUserName(String userName) {
        StringBuilder sql = new StringBuilder();
        sql.append("Select * from User where user_name = :userName");
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("userName",userName);
        List<Object[]> objects = query.getResultList();
        if (objects != null && !objects.isEmpty()){
            Object[] obj = objects.get(0);
            User user = new User();
            user.setId(Long.parseLong(obj[0].toString()));
            user.setUserName(obj[1].toString());
            user.setPassword(obj[3].toString());
            return user;
        }
        return null;
    }
}
