package com.cst8277.usermanagementservice.controller;

import com.cst8277.usermanagementservice.entity.Role;
import com.cst8277.usermanagementservice.entity.User;
import com.cst8277.usermanagementservice.handler.CustomErrorResponse;
import com.cst8277.usermanagementservice.service.RoleService;
import com.cst8277.usermanagementservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/ums/roles")
public class RoleController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    //Create role
    @PostMapping("/")
    public Role saveRole(@RequestBody Role role) {
        LOGGER.info("Role add: {}", role);
        return roleService.saveRole(role);
    }

    //Get role by id
    @GetMapping("/id/{id}")
    public Role findById(@PathVariable("id") UUID id){
        LOGGER.info("Role find: {}", id);
        return roleService.findByIdCustom(id);
    }
    //Get all roles
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        LOGGER.info("Find all roles");
        List<Role> roles = roleService.findAll();
        CustomErrorResponse response = new CustomErrorResponse
                (Integer.toString(HttpStatus.OK.value()), roles, "All roles successfully retrieved");
        return ResponseEntity.ok(response);
    }

    //Delete role
    @DeleteMapping("/delete/{id}")
    public Optional<Role> deleteById(@PathVariable("id") UUID id) {
        LOGGER.info("Role delete: {}", id);
        return roleService.deleteById(id);
    }
    //Update role
    @PutMapping("/update/{id}")
    public Optional<Role> updateRole(@PathVariable("id") UUID id, @RequestBody Role updatedRole) {
        return roleService.updateRole(id, updatedRole);
    }

}
