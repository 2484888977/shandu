package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.CommentMapper;
import com.shandu.mapper.NoteMapper;
import com.shandu.pojo.Comment;
import com.shandu.pojo.Comment_View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private NoteMapper noteMapper;

    //    作者id查询评论
    @Override
    public List<Comment_View> selectComment01(int code, int userid) {
        return commentMapper.selectComment01(code, userid);
    }

    //    笔记id查询评论/通知
    @Override
    public List<Comment_View> selectComment02(int code, int note_id) {
        return commentMapper.selectComment02(code, note_id);
    }

    //添加评论
    @Override
    public JSON addComment(Comment comment ,int comnum) {
        JSONObject json = new JSONObject();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setDatatime(df.format(new Date()));
        comment.setCollecnum(0);
        int comnum1 =comnum+1;
        System.out.println(comnum1);
        noteMapper.updateNote02(comnum1,comment.getNote_id());
        int code = commentMapper.addComment(comment);
        if (code == 1) {
            json.put("msg", "添加成功");
            json.put("code", 1);
        } else {
            json.put("msg", "添加失败");
            json.put("code", 0);
        }
        return json;
    }

    //    评论id查询评论
    @Override
    public Comment_View selectComment03(int commentid) {
        return commentMapper.selectComment03(commentid);
    }

    //修改评论
    @Override
    public JSON updateComment(Comment comment) {
        JSONObject json = new JSONObject();
        try {
            int code = commentMapper.updateComment(comment);
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

    //删除评论
    @Override
    public JSON deleteComment(int commentid) {
        JSONObject json = new JSONObject();
        try {
            int code = commentMapper.deleteComment(commentid);
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

    @Override
    public List<Comment_View> selectComment(int page, int limit, String keyword) {
        return commentMapper.selectComment(page, limit, keyword);
    }
}
