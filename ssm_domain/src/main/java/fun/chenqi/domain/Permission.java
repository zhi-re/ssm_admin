package fun.chenqi.domain;

import java.util.List;

public class Permission {
    private Long id;
    private String permissionName;
    private String url;
    private String pid;
    private List<Role> roles; // 权限和角色是多对多的关系

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", pid='" + pid + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Permission() {
    }

    public Permission(Long id, String permissionName, String url, String pid, List<Role> roles) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
        this.pid = pid;
        this.roles = roles;
    }
}

