package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Admin;
import com.shandu.pojo.Note;
import com.shandu.pojo.Note_View;
import com.shandu.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    //管理员登录
    JSON login(Admin admin, HttpSession session);

    //    添加用户
    JSON addUser(User user);

    //    通过vx_id查询用户
    JSON selectUserVx(String vx_id);

    //    查询用户
    List<User> selectUser(int page, int limit, String keyword);

    //    更改用户
    JSON updateUser(User user);
    // 删除用户
    JSON deleteUser(int u_id);

}
