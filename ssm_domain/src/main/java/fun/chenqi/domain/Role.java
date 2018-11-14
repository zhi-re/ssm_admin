package fun.chenqi.domain;

import java.util.List;

public class Role {
    private Long id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions; // 权限和角色多对多的关系
    private List<SysUser> users; // 用户和角色多对多的关系


    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public Role(Long id, String roleName, String roleDesc, List<Permission> permissions, List<SysUser> users) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.permissions = permissions;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}
