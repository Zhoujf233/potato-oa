package com.potato.auth;

import com.potato.auth.mapper.SysRoleMapper;
import com.potato.auth.service.SysRoleService;
import com.potato.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: TestMpDemo2
 * Package: com.potato.auth
 * Description:
 *
 * @Author: ZhouJF
 * @Create: 2023/4/4 - 7:26 PM
 */
@SpringBootTest
public class TestMpDemo2 {
    //注入
    @Autowired
    private SysRoleService service;

    //查询所有记录
    @Test
    public void testGetAll(){
        List<SysRole> list = service.list();
        System.out.println(list);
    }
}
