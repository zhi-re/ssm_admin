package fun.chenqi.dao;

import fun.chenqi.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SysDao {
    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(
                            select = "fun.chenqi.dao.RoleDao.findOne",
                            fetchType = FetchType.LAZY
                    ))
    }
    )
    SysUser fundByName(String name);

    @Select("select * from sys_user")
    List<SysUser> findAllUser();

    @Insert("insert into sys_user values(common_sequence.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser user);

    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(
                            select = "fun.chenqi.dao.RoleDao.findOne",
                            fetchType = FetchType.LAZY
                    ))
    }
    )
    SysUser findOne(Long id);
}
