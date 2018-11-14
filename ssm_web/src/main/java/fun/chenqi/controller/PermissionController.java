package fun.chenqi.controller;

import fun.chenqi.domain.Permission;
import fun.chenqi.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService service;


    @RequestMapping("/findAllPermission")
    public String findAll(Model model) {
        List<Permission> list = service.findAllPermission();
        model.addAttribute("list", list);
        return "permission-list";
    }

    @RequestMapping("/savePermission")
    public String save(Permission permission) {
     //   System.out.println(permission);
        service.save(permission);
        return "redirect:findAllPermission";
    }


}
