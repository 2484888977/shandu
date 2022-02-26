package com.shandu.mapper;

import com.shandu.pojo.Admin;
import com.shandu.pojo.Note;
import com.shandu.pojo.Note_View;
import com.shandu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //     管理员登录
    Admin login(Admin admin);

    //     添加用户
    int addUser(User user);

    //    通过vx_id查询用户
    User selectUserVx(String name);

    //    查询用户
    List<User> selectUser(int page, int limit, String keyword);

    //    更改用户
    int updateUser(User user);
    //    删除用户
    int deleteUser(int u_id);
}
