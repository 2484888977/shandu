package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Comment;
import com.shandu.pojo.Comment_View;
import com.shandu.pojo.Note;

import java.util.List;

public interface CommentService {
    // 作者id查询评论
    List<Comment_View> selectComment01(int code, int userid);

    //    笔记id查询评论/通知
    List<Comment_View> selectComment02(int code, int note_id);

    //    添加评论
    JSON addComment(Comment comment, int comnum);

    //    评论id查询评论
    Comment_View selectComment03(int commentid);

    //    修改评论
    JSON updateComment(Comment comment);

    //    删除评论
    JSON deleteComment(int commentid);

    //    查询评论
    List<Comment_View> selectComment(int page, int limit, String keyword);
}
