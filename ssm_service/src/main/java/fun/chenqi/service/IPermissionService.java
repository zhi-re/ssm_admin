package fun.chenqi.service;

import fun.chenqi.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAllPermission();


    void save(Permission permission);
}
