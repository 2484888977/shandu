package com.shandu.mapper;

import com.shandu.pojo.Comment;
import com.shandu.pojo.Comment_View;
import com.shandu.pojo.Note_View;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    // 作者id查询评论
    List<Comment_View> selectComment01(int code, int userid);

    // 笔记id查询评论/通知
    List<Comment_View> selectComment02(int code, int note_id);

    //    添加评论
    int addComment(Comment comment);

    //    评论id查询评论
    Comment_View selectComment03(int commentid);

    //    修改评论
    int updateComment(Comment comment);

    //    删除评论
    int deleteComment(int commentid);
    //    查询评论
    List<Comment_View> selectComment(int page, int limit, String keyword);
}
