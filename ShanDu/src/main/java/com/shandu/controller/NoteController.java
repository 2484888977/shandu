package com.shandu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.NoteMapper;
import com.shandu.pojo.Note;
import com.shandu.service.NoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("NoteController")
@Api(tags = "笔记相关接口")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteMapper noteMapper;

    //添加笔记
    @GetMapping("/addNote")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "发布笔记", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "majorid", value = "专业id", dataType = "int", required = true),
            @ApiImplicitParam(name = "subjectid", value = "学科id", dataType = "int", required = true),
            @ApiImplicitParam(name = "userid", value = "用户id", dataType = "int"),
            @ApiImplicitParam(name = "title", value = "笔记标题", dataType = "String"),
            @ApiImplicitParam(name = "contentinfo", value = "笔记内容", dataType = "String")})
    public JSON addNote(Note note) {
        return noteService.addNote(note);
    }

    //更改笔记
    @GetMapping("/updateNote")
    @ResponseBody
    @CrossOrigin
    public JSON updateNote(Note note) {
        return noteService.updateNote(note);
    }

    //删除笔记
    @GetMapping("/deleteNote")
    @ResponseBody
    @CrossOrigin
    public JSON deleteNote(int id) {
        return noteService.deleteNote(id);
    }

    //收藏笔记
    @GetMapping("/collecNote")
    @ResponseBody
    @CrossOrigin
    public JSON collecNote(Note note) {
        return noteService.collecNote(note);
    }

    //    查询笔记
    @GetMapping("/selectNote")
    @ResponseBody
    @CrossOrigin
    public JSON selectNote(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", noteService.selectNote(0, 10000, keyword).size());
        json.put("data", noteService.selectNote(page2, limit, keyword));
        return json;
    }

    //    查询推荐笔记
    @GetMapping("/selectNoteTuiJ")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询推荐笔记", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int", required = true)})
    public JSON selectNoteTuiJ(int page, int limit) {
        return noteService.selectNoteTuiJ(page, limit, null);
    }

    //    关键字查询推荐笔记
    @GetMapping("/selectNoteTuiJ01")
    @ResponseBody
    @CrossOrigin
//    @ApiOperation(value = "查询推荐笔记", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", value = "页数", dataType = "int", required = true),
//            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int", required = true)})
    public JSON selectNoteTuiJ01(int page, int limit, String keyword) {
        return noteService.selectNoteTuiJ(page, limit, keyword);
    }

    //    笔记变推荐笔记/推荐笔记变笔记
    @GetMapping("/updateNote01")
    @ResponseBody
    @CrossOrigin
    public JSON updateNote01(Note note) {
        return noteService.updateNote01(note);
    }

    //    笔记id查询笔记
    @GetMapping("/selectNoteNId")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询推荐笔记", notes = "")
    @ApiImplicitParam(name = "id", value = "笔记id", dataType = "int", required = true)
    public JSON selectNoteNId(int id) {
        return noteService.selectNoteNId(id);
    }

    //    查询学科笔记
    @GetMapping("/selectNoteMajor")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询学科笔记", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int", required = true),
            @ApiImplicitParam(name = "subjectid", value = "学科id", dataType = "int", required = true),})
    public JSON selectNoteMajor(int page, int limit, int subjectid) {
        return noteService.selectNoteMajor(page, limit, subjectid);
    }

    //    查询我的笔记/用户id查笔记
    @GetMapping("/selectNoteId")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询我的笔记/用户id查笔记", notes = "")
    @ApiImplicitParam(name = "userid", value = "用户id", dataType = "int", required = true)
    public JSON selectNoteId(int userid) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", noteMapper.selectNoteId(userid).size());
        json.put("data", noteMapper.selectNoteId(userid));
        return json;
    }

    //    查询我的收藏笔记/用户查收藏笔记
    @GetMapping("/selectNoteIdColl")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询我的收藏笔记/用户查收藏笔记", notes = "")
    @ApiImplicitParam(name = "collecid", value = "用户收藏id   填1", dataType = "int", required = true)
    public JSON selectNoteIdColl(int collecid) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", noteMapper.selectNoteIdColl(collecid).size());
        json.put("data", noteMapper.selectNoteIdColl(collecid));
        return json;
    }
}
