package fun.chenqi.service;

import fun.chenqi.domain.Permission;
import fun.chenqi.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAllRole();

    void addRole(Role role);

    void ManageRoleAddDelUpd(Long userId, Long[] ids);

    Role findPermissionById(Long id);

    void addPermissionToRole(Long[] permissionIds, Long roleId);
}
