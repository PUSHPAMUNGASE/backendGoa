package com.example.controller;
//
//
//
//import com.example.entity.Role;
//import com.example.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/roles")
//public class RoleController {
//
//    @Autowired
//    private RoleService roleService;
//
//    @PostMapping("/create")
//    public Role createRole(@RequestParam String roleName) {
//        return roleService.createRole(roleName);
//    }
//
//    @GetMapping("/{roleName}")
//    public Role getRoleByName(@PathVariable String roleName) {
//        return roleService.getRoleByName(roleName)
//                .orElseThrow(() -> new RuntimeException("Role not found"));
//    }
//}



import com.example.entity.Role;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public Role createRole(@RequestParam String roleName) {
        return roleService.createRole(roleName);
    }

    @GetMapping("/{roleName}")
    public Role getRoleByName(@PathVariable String roleName) {
        return roleService.getRoleByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }
}

