package com.xinda.um.user.mapper;

import com.xinda.um.user.dto.SysUser;

import java.util.List;

/**
 * UserMapper映射接口.
 *
 * @Author Coundy.
 * @Date 2017/3/27 21:57
 */
public interface SysUserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 获取User信息.
     *
     * @param sysUser User参数对象
     * @return SysUser
     */
    List<SysUser> getSysUsers(SysUser sysUser);

    /**
     * 查询用户信息.
     *
     * @param sysUser
     * @return
     */
    SysUser querySysUserBySysUser(SysUser sysUser);

}
