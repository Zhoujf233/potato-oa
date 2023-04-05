package com.potato.auth.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.potato.auth.mapper.SysRoleMapper;
import com.potato.auth.service.SysRoleService;
import com.potato.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: SysRoleServiceImpl
 * Package: com.potato.auth.service.Impl
 * Description:
 *
 * @Author: ZhouJF
 * @Create: 2023/4/4 - 7:19 PM
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    // @Autowired
    // private SysRoleMapper sysRoleMapper;
}
