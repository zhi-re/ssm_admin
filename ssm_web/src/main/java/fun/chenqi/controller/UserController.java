package fun.chenqi.controller;

import fun.chenqi.domain.Role;
import fun.chenqi.domain.SysUser;
import fun.chenqi.service.IRoleService;
import fun.chenqi.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ISysUserService service;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService roleService;

    // 查询所有用户
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model) {
        List<SysUser> user = service.findAllUser();
        //  System.out.println(user);
        model.addAttribute("userList", user);
        return "user-list";

    }

    // 添加用户
    @RequestMapping("/save")
    public String save(SysUser user) {
        String password = user.getPassword();
        String newPass = passwordEncoder.encode(password);
        user.setPassword(newPass);
        service.save(user);
        return "redirect:/user/findAllUser";
    }

    // 查询用户详情
    @RequestMapping("/findOne")
    public String findOne(Model model, Long id) {
        SysUser user = service.findOne(id);
        // System.out.println(user);
        model.addAttribute("user", user);
        return "user-show";
    }


    // 管理数据 实现复选框选中功能
    @RequestMapping("/managerUserRole")
    public String managerUserRole(Model model, Long id) {
        // 查询用户信息
        SysUser user = service.findOne(id);
        System.out.println(user);

        // 查询用户具有的角色
        List<Role> roles = user.getRoles();

        //将所有的角色信息拼装成一个角色字符串用于页面的包含判断
        if (roles != null && roles.size() > 0) {
            StringBuffer sb = new StringBuffer();
            for (Role role : roles) {
                sb.append(role.getRoleName() + ",");
            }
            model.addAttribute("rStr", sb);
        }
        // 查询所有角色信息
        List<Role> roleList = roleService.findAllRole();
        model.addAttribute("roleList", roleList);
        //  model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "user-role-add";
    }

    // 管理数据 实现角色的增加 修改 删除
    @RequestMapping("/ManageRoleAddDelUpd")
    public String ManageRoleAddDelUpd(Long userId, Model model, Long ids[]) {
        roleService.ManageRoleAddDelUpd(userId, ids);
        return "redirect:findAllUser";
    }
}
