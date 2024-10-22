package com.example.demo.controller;

import com.example.demo.model.PermissionGroup;
import com.example.demo.service.IPermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissiongroup")
public class PermissionGroupController {

    @Autowired
    private IPermissionGroupService iPermissionGroupService;

    @GetMapping
    public List<PermissionGroup> getAllPermissionGroup(){
        return iPermissionGroupService.getAllPermissionGroup();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionGroup> getPermissionGroupById(@PathVariable Long id){
        PermissionGroup permissionGroup = iPermissionGroupService.getPermissionGroupById(id);
        return ResponseEntity.ok(permissionGroup);
    }

    @PostMapping
    public ResponseEntity<PermissionGroup> createPermissionGroup(@RequestBody PermissionGroup permissionGroup){
        PermissionGroup createPermissionGroup = iPermissionGroupService.createPermissionGroup(permissionGroup);
        return ResponseEntity.ok(createPermissionGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionGroup> updatePermissionGroup(@PathVariable Long id, @RequestBody PermissionGroup permissionGroup){
        PermissionGroup updatePermissionGroup = iPermissionGroupService.updatePermissionGroup(id, permissionGroup);
        return ResponseEntity.ok(updatePermissionGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PermissionGroup> deletePermissionGroup(@PathVariable Long id){
        iPermissionGroupService.deletePermissionGroup(id);
        return ResponseEntity.noContent().build();
    }
}
