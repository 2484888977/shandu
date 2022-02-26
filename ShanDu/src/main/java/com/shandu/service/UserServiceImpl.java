package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.CommentMapper;
import com.shandu.mapper.UserMapper;
import com.shandu.pojo.Admin;
import com.shandu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //登录
    @Override
    public JSON login(Admin admin, HttpSession session) {
        JSONObject json = new JSONObject();
        Admin login = (Admin) userMapper.login(admin);
        if (login != null) {
            login.setPassword("");
            json.put("msg", "登录成功");
            json.put("data", login);
            json.put("code", 1);
            session.setAttribute("login_session", login);
        } else {
            json.put("msg", "登录失败");
            json.put("data", null);
            json.put("code", 0);
        }
        return json;
    }

    //    添加用户
    @Override
    public JSON addUser(User user) {
        JSONObject json = new JSONObject();
        user.setIntroduce("个人介绍还没有写哦。");
        user.setSex("未知");
        user.setBirthday("2022-1-1");
        int code = userMapper.addUser(user);
        if (code == 1) {
            json.put("msg", "添加成功");
            json.put("code", 1);
        } else {
            json.put("msg", "添加失败");
            json.put("code", 0);
        }
        return json;
    }

    //    通过vx_id查询用户
    @Override
    public JSON selectUserVx(String vx_id) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "查询成功");
//        json.put("count",userMapper.selectUserVx(vx_id).);
        json.put("data", userMapper.selectUserVx(vx_id));
        return json;
    }

    //    查询用户
    @Override
    public List<User> selectUser(int page, int limit, String keyword) {
        return userMapper.selectUser(page, limit, keyword);
    }

    //更改用户
    @Override
    public JSON updateUser(User user) {
        JSONObject json = new JSONObject();
        try {
            int code = userMapper.updateUser(user);
            if (code == 1) {
                json.put("code", 1);
                json.put("msg", "修改信息成功");
            } else {
                json.put("code", 0);
                json.put("msg", "修改信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常，请稍后重试");
            json.put("code", -1);
        }
        return json;
    }

    //删除用户
    @Override
    public JSON deleteUser(int u_id) {
        JSONObject json = new JSONObject();
        try {
            int code = userMapper.deleteUser(u_id);
            if (code == 1) {
                json.put("code", 1);
                json.put("msg", "删除信息成功");
            } else {
                json.put("code", 0);
                json.put("msg", "删除信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常，请稍后重试");
            json.put("code", -1);
        }
        return json;
    }
}
