package com.potato.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.potato.auth.service.SysRoleService;
import com.potato.common.result.Result;
import com.potato.model.system.SysRole;
import com.potato.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: SysRoleController
 * Package: com.potato.auth.controller
 * Description:
 *
 * @Author: ZhouJF
 * @Create: 2023/4/4 - 7:35 PM
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    //注入Service
    @Autowired
    private SysRoleService sysRoleService;

    //查询所有角色
    // @GetMapping("/findAll")
    // public List<SysRole> findAll(){
    //     //调用service方法
    //     List<SysRole> list = sysRoleService.list();
    //     return list;
    // }

    //统一返回数据结果
    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result findAll(){
        //调用service方法
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    //条件分页查询
    //page 当前页 limit 每页显示记录数
    //SysRoleQueryVo 条件对象
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo){
        //调用service方法实现
        //1 创建Page对象，传递分页相关参数
        //page 当前页 limit 每页显示记录数
        Page<SysRole> pageParam = new Page<>(page,limit);

        //2 封装条件，判断是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)){
            //封装 like模糊查询
            wrapper.like(SysRole::getRoleName,roleName);
        }

        //3 调用方法实现
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }

    //添加角色
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result save(@RequestBody SysRole sysRole){
        //调用service方法
        boolean is_success = sysRoleService.save(sysRole);
        if (is_success){
            return Result.ok();
        }
        else {
            return Result.fail();
        }
    }

    //修改角色-根据id查询
    @ApiOperation("根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);

    }
    //修改角色-最终修改
    @ApiOperation("修改角色")
    @PostMapping("update")
    public Result update(@RequestBody SysRole sysRole){
        //调用service方法
        boolean is_success = sysRoleService.updateById(sysRole);
        if (is_success){
            return Result.ok();
        }
        else {
            return Result.fail();
        }
    }

}
