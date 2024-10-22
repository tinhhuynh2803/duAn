package com.example.demo.service.impl;

import com.example.demo.model.PermissionGroup;
import com.example.demo.repository.PermissionGroupRepository;
import com.example.demo.service.IPermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionGroupServiceImpl implements IPermissionGroupService {

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Override
    public List<PermissionGroup> getAllPermissionGroup() {
        return permissionGroupRepository.findAll();
    }

    @Override
    public PermissionGroup getPermissionGroupById(Long id) {
        return permissionGroupRepository.findById(id).orElseThrow();
    }

    @Override
    public PermissionGroup createPermissionGroup(PermissionGroup permissionGroup) {
        return permissionGroupRepository.save(permissionGroup);
    }

    @Override
    public PermissionGroup updatePermissionGroup(Long id, PermissionGroup permissionGroup) {
        PermissionGroup existingPermissionGroup = permissionGroupRepository.findById(id).orElseThrow();
        existingPermissionGroup.setName(permissionGroup.getName());
        existingPermissionGroup.setNote(permissionGroup.getNote());
        return permissionGroupRepository.save(existingPermissionGroup);
    }

    @Override
    public void deletePermissionGroup(Long id) {
        permissionGroupRepository.deleteById(id);
    }
}
