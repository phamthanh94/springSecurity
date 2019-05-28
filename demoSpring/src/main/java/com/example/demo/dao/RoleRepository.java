package com.example.demo.dao;

import java.util.List;

public interface RoleRepository {

    public List<String> getListRoleNameByUserId(Long userId);
}
