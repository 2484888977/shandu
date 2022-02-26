package com.shandu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.pojo.Admin;
import com.shandu.pojo.User;
import com.shandu.service.UserService;
import com.shandu.until.until;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 一个用来测试swagger注解的控制器
 * 注意@ApiImplicitParam的使用会影响程序运行，如果使用不当可能造成控制器收不到消息
 *
 * @author SUNF
 */
@Controller
@RequestMapping("UserController")
@Api(tags = "用户管理相关接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getVoucher")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="获取上传凭证", notes="无需传参")
//    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public JSON voucher() {
        JSONObject json = new JSONObject();
        until until = new until();
        json.put("code", 1);
        json.put("msg", "获取凭证成功");
        json.put("data", until.File());
        return json;
    }

    //管理员登录
    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    public JSON login(Admin admin, HttpSession session) {
        return userService.login(admin, session);
    }

    /**
     * 从session中获取登录状态
     *
     * @param session
     * @param key
     * @return
     */
    @PostMapping("/session")
    @ResponseBody
    @CrossOrigin
    public Object session(HttpSession session, String key) {
        return session.getAttribute(key);
    }

    //添加用户
    @GetMapping("/adduser")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="添加用户", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="用户昵称",dataType="string",required=true),
            @ApiImplicitParam(name="vx_head",value="用户头像链接",dataType="string",required=true),
            @ApiImplicitParam(name="birthday",value="用户生日",dataType="string"),
            @ApiImplicitParam(name="collecnber",value="用户收藏数",dataType="int"),
            @ApiImplicitParam(name="notenber",value="用户笔记数",dataType="int"),
            @ApiImplicitParam(name="introduce",value="用户个人介绍",dataType="string"),
            @ApiImplicitParam(name="sex",value="用户性别",dataType="string"),
            @ApiImplicitParam(name="vx_id",value="用户openid唯一标识",dataType="string",required=true)})
    public JSON adduser(User user) {
        return userService.addUser(user);
    }

    //    通过vx_id查询用户
    @GetMapping("/selectUserVx")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="通过vx_id查询用户", notes="")
    @ApiImplicitParam(name="vx_id",value="用户openid唯一标识",dataType="string",required=true)
    public JSON selectUserVx(String vx_id) {
        return userService.selectUserVx(vx_id);
    }

    //更改用户
    @GetMapping("/updateUser")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="更改用户", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name="u_id",value="修改用户的id",dataType="int",required=true),
            @ApiImplicitParam(name="name",value="用户昵称",dataType="string"),
            @ApiImplicitParam(name="vx_head",value="用户头像链接",dataType="string"),
            @ApiImplicitParam(name="birthday",value="用户生日",dataType="string"),
            @ApiImplicitParam(name="collecnber",value="用户收藏数",dataType="int"),
            @ApiImplicitParam(name="notenber",value="用户笔记数",dataType="int"),
            @ApiImplicitParam(name="introduce",value="用户个人介绍",dataType="string"),
            @ApiImplicitParam(name="sex",value="用户性别",dataType="string"),
            @ApiImplicitParam(name="vx_id",value="用户openid唯一标识",dataType="string")})
    public JSON updateUser(User user) {
        return userService.updateUser(user);
    }

    //删除用户
    @GetMapping("/deleteUser")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="删除用户", notes="")
    @ApiImplicitParam(name="u_id",value="删除用户的id",dataType="int",required=true)
    public JSON deleteUser(int u_id) {
        return userService.deleteUser(u_id);
    }

    //    查询用户
    @GetMapping("/selectUser")
    @ResponseBody
    @CrossOrigin
    public JSON selectUser(int page, int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", userService.selectUser(0, 10000, null).size());
        json.put("data", userService.selectUser(page2, limit, null));
        return json;
    }
    //    关键字查询用户
    @GetMapping("/selectWhereUser")
    @ResponseBody
    @CrossOrigin
    public JSON selectWhereUser(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", userService.selectUser(0, 10000, keyword).size());
        json.put("data", userService.selectUser(page2, limit, keyword));
        return json;
    }
}
