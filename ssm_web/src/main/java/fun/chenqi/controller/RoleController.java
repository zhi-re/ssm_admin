package fun.chenqi.controller;


import fun.chenqi.domain.Permission;
import fun.chenqi.domain.Role;
import fun.chenqi.service.IPermissionService;
import fun.chenqi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService service;
    @Autowired
    private IPermissionService permissionService;

    // 查询所有角色
    @RequestMapping("/findAllRole")
    public String findAllRole(Model model) throws Exception {
        List<Role> list = service.findAllRole();
        model.addAttribute("roleList", list);
       /* for (Role role : list) {
            System.out.println(role);
        }*/
        return "role-list";
    }

    // 添加角色
    @RequestMapping("/addRole")
    public String addRole(Model model, Role role) throws Exception {
        service.addRole(role);
        return "redirect:findAllRole";
    }

    // 给角色添加权限:先根据ID查询该角色具有的权限
    @RequestMapping("/manageRolePermission")
    public String manageRolePermission(Model model, Long id) throws Exception {
        System.out.println("id= " + id);
        // 根据角色ID查询权限
        Role role = service.findPermissionById(id);
        System.out.println(role);
        List<Permission> list = role.getPermissions();

        //将所有的角色信息拼装成一个角色字符串用于页面的包含判断
        if (list != null && list.size() > 0) {
            StringBuffer sb = new StringBuffer();
            for (Permission permission : list) {
                sb.append(permission.getPermissionName() + ",");
            }
            // System.out.println("SB=====" + sb);
            model.addAttribute("Str", sb);
        }

        // 查询所有的权限
        List<Permission> allPermission = permissionService.findAllPermission();
        model.addAttribute("permissionList", allPermission);
        /*for (Permission permission : allPermission) {
            System.out.println("allper=====" + permission.getPermissionName());
        }*/
        model.addAttribute("role", role);

        return "role-permission-add";
    }


    // 角色权限的增删改
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(Long roleId, Long ids[]) { // TODO 这俩参数值 需要和页面传来的name值保持一致！！！
        for (Long permissionId : ids) {
            System.out.println("per: " + permissionId);
        }

        System.out.println("roleID: " + roleId);
        service.addPermissionToRole(ids, roleId);
        return "redirect:findAllRole";
    }
}
