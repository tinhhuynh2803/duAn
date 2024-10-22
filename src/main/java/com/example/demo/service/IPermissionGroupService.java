package com.example.demo.service;

import com.example.demo.model.PermissionGroup;

import java.util.List;

public interface IPermissionGroupService {

    public List<PermissionGroup> getAllPermissionGroup();
    public PermissionGroup getPermissionGroupById(Long id);
    public PermissionGroup createPermissionGroup(PermissionGroup permissionGroup);
    public PermissionGroup updatePermissionGroup(Long id, PermissionGroup permissionGroup);
    public void deletePermissionGroup(Long id);
}
