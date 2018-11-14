package fun.chenqi.service.impl;

import fun.chenqi.dao.RoleDao;
import fun.chenqi.domain.Permission;
import fun.chenqi.domain.Role;
import fun.chenqi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleDao dao;

    // 查询所有的角色
    @Override
    public List<Role> findAllRole() {
        List<Role> list = dao.findAllRole();
        return list;
    }

    // 添加角色
    @Override
    public void addRole(Role role) {
        dao.addRole(role);
    }

    // 管理角色的增删改
    @Override
    public void ManageRoleAddDelUpd(Long userId, Long[] ids) {

        // 先删除用户的原始角色
        dao.deleteByUserId(userId);

        if (ids != null && ids.length > 0) {
            for (Long roleId : ids) {
                dao.saveUserRole(userId, roleId);
            }
        }
    }

    // 根据ID查角色具有的权限
    @Override
    public Role findPermissionById(Long id) {
        Role role = dao.findPermissionById(id);
        return role;
    }

    // 角色权限的增删改
    @Override
    public void addPermissionToRole(Long[] permissionIds, Long roleId) {
        // 删除原始权限
        dao.deleteByRoleId(roleId);
        if (permissionIds != null && permissionIds.length > 0) {
            for (Long permissionId : permissionIds) {
                dao.addPermissionToRole(permissionId, roleId);
            }
        }
    }
}
