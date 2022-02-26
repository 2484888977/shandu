package com.shandu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.pojo.Comment;
import com.shandu.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("CommentController")
@Api(tags = "评论相关接口")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //作者id查询评论/通知
    @GetMapping("/selectComment01")
    @ResponseBody
    @CrossOrigin
    public JSON selectComment01(int code, int userid) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", commentService.selectComment01( code, userid).size());
        json.put("data", commentService.selectComment01( code, userid));
        return json;
    }
    //笔记id查询评论/通知
    @GetMapping("/selectComment02")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="笔记id查询评论", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value="查找评论填1",dataType="int",required=true),
            @ApiImplicitParam(name="note_id",value="笔记id",dataType="int",required=true)})
    public JSON selectComment02(int code, int note_id) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", commentService.selectComment02( code, note_id).size());
        json.put("data", commentService.selectComment02( code, note_id));
        return json;
    }
    //添加评论
    @GetMapping("/addComment")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="添加评论", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value="添加评论填1",dataType="int",required=true),
            @ApiImplicitParam(name="u_id",value="用户id",dataType="int",required=true),
            @ApiImplicitParam(name="content",value="评论内容",dataType="String",required=true),
            @ApiImplicitParam(name="note_id",value="笔记id",dataType="int",required=true)})
    public JSON addComment(Comment comment,int comnum) {
        return commentService.addComment(comment,comnum);
    }
    //评论id查询评论
    @GetMapping("/selectComment03")
    @ResponseBody
    @CrossOrigin
    public JSON selectComment03(int commentid) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "查询信息成功");
        json.put("data", commentService.selectComment03(commentid));
        return json;
    }
    //删除评论
    @GetMapping("/deleteComment")
    @ResponseBody
    @CrossOrigin
    public JSON deleteComment(int commentid) {
        return commentService.deleteComment(commentid);
    }
    //更改评论
    @GetMapping("/updateComment")
    @ResponseBody
    @CrossOrigin
    public JSON updateComment(Comment comment) {
        return commentService.updateComment(comment);
    }
    //    查询评论
    @GetMapping("/selectComment")
    @ResponseBody
    @CrossOrigin
    public JSON selectComment(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", commentService.selectComment(0, 10000, keyword).size());
        json.put("data", commentService.selectComment(page2, limit, keyword));
        return json;
    }
}
