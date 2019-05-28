package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private EntityManager em;

    @Override public List<String> getListRoleNameByUserId(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT r.role_name FROM User_Role ur inner join Role r where ur.role_id = r.role_id and ur.user_id = :userId");
        Query query = em.createNativeQuery(sql.toString());
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
