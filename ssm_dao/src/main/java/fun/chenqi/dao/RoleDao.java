package fun.chenqi.dao;

import fun.chenqi.domain.Permission;
import fun.chenqi.domain.Role;
import fun.chenqi.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDao {

    // 查询用户的时候查询该用户所有的权限
    @Select("SELECT sr.* FROM sys_role sr,sys_user_role sur WHERE sr.id = sur.roleId AND sur.userId = #{id}")
    @Results({
            @Result(property = "permissions", column = "id", javaType = List.class,
                    many = @Many(select = "fun.chenqi.dao.PermissionDao.findByRoleId", fetchType = FetchType.LAZY))
    })
    List<Role> findOne(Long id);

    // 查询所有角色
    @Select("select * from sys_role")
    List<Role> findAllRole();

    // 添加角色
    @Insert("insert into sys_role values(common_sequence.nextval,#{roleName},#{roleDesc})")
    void addRole(Role role);

    // 删除用户的原始角色
    @Delete("delete from sys_user_role where userId = #{userId}")
    void deleteByUserId(Long userId);

    // 给用户添加角色
    @Insert("insert into sys_user_role values(#{userId},#{roleId})")
    void saveUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    // 根据ID查角色具有的权限
    @Select("select * from sys_role where id =#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),// todo 这句话不能掉！！！！
            @Result(property = "permissions", column = "id", javaType = List.class,
                    many = @Many(select = "fun.chenqi.dao.PermissionDao.findByRoleId", fetchType = FetchType.LAZY))
    })
    Role findPermissionById(Long id);

    // 删除角色的原始权限
    @Delete("delete from sys_role_permission where roleId = #{roleId}")
    void deleteByRoleId(Long roleId);

    // 给角色加入权限
    @Insert("insert into sys_role_permission values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("permissionId") Long permissionId, @Param("roleId") Long roleId);
}
