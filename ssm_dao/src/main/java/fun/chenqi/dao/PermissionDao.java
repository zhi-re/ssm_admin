package fun.chenqi.dao;

import fun.chenqi.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    // 根据角色ID查询角色
    @Select("SELECT sp.* FROM sys_permission sp,sys_role_permission srp WHERE sp.id = srp.permissionId AND srp.roleId = #{id}")
    public List<Permission> findByRoleId(Long id);

    // 查询所有角色
    @Select("select * from sys_permission")
    List<Permission> findAllPermission();

    // 添加角色
    @Insert("insert into sys_permission (id,permissionName,url) values(common_sequence.nextval,#{permissionName},#{url})")
    void save(Permission permission);
}
