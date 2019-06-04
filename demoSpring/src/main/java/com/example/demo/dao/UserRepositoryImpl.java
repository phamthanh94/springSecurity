package com.example.demo.dao;

import com.example.demo.Utils.WebUtils;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    @Cacheable(cacheNames = "cache.security.users", key = "#userName", unless = "#result == null")
    public User findUserByUserName(String userName) {
        StringBuilder sql = new StringBuilder();
        sql.append("Select * from customer where user_name = :userName");
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("userName",userName);
        List<Object[]> objects = query.getResultList();
        if (objects != null && !objects.isEmpty()){
            Object[] obj = objects.get(0);
            User user = new User();
            user.setId(Long.parseLong(obj[0].toString()));
            user.setUserName(obj[1].toString());
            user.setStatus(Short.parseShort(obj[2].toString()));
            user.setPassword(obj[3].toString());
            user.setEmail(obj[4].toString());
            user.setRoleName(obj[5].toString());
            return user;
        }
        return null;
    }

    @Override
    public void createUser(String username, String password, String email, String role) {
        StringBuilder sql = new StringBuilder();
        String pw = WebUtils.encryte(password);
        sql.append("Insert into customer (user_id,user_name,password,status,email,role_name)");
        sql.append(" Values (null,").append("'").append(username).append("'");
        sql.append(",").append("'").append(pw).append("'");
        sql.append(",").append("'").append(1).append("'");
        sql.append(",").append("'").append(email).append("'");
        sql.append(",").append("'").append(role).append("'");
        sql.append(")");
        Query query = em.createNativeQuery(sql.toString());
        query.executeUpdate();
    }
}
