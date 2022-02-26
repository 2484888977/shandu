package com.shandu.service;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.NoteMapper;
import com.shandu.pojo.Note;
import com.shandu.pojo.Note_View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    //    添加笔记
    @Override
    public JSON addNote(Note note) {
        JSONObject json = new JSONObject();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        note.setDatatime(df.format(new Date()));
        note.setComnum(0);
        note.setCollecnum(0);
        note.setCollecid(0);
        note.setRecommendid(0);
        int code = noteMapper.addNote(note);
        if (code == 1) {
            json.put("msg", "添加成功");
            json.put("code", 1);
        } else {
            json.put("msg", "添加失败");
            json.put("code", 0);
        }
        return json;
    }

    //    查询笔记
    @Override
    public List<Note_View> selectNote(int page, int limit, String keyword) {
        return noteMapper.selectNote(page, limit, keyword);
    }

    //笔记id查询笔记
    @Override
    public JSON selectNoteNId(int id) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", noteMapper.selectNoteNId(id).size());
        json.put("data", noteMapper.selectNoteNId(id));
        return json;
    }

    //    查询推荐笔记
    @Override
    public JSON selectNoteTuiJ(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", noteMapper.selectNoteTuiJ(0, 10000, keyword).size());
        json.put("data", noteMapper.selectNoteTuiJ(page2, limit, keyword));
        return json;
    }

    //    笔记变推荐笔记/推荐笔记变笔记
    @Override
    public JSON updateNote01(Note note) {
        JSONObject json = new JSONObject();
        try {
            int code = noteMapper.updateNote01(note);
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

    //查询对应专业学科笔记
    @Override
    public JSON selectNoteMajor(int page, int limit, int subjectid) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", noteMapper.selectNoteMajor(0, 100000, subjectid).size());
        json.put("data", noteMapper.selectNoteMajor(page2, limit, subjectid));
        return json;
    }

    //    收藏笔记
    @Override
    public JSON collecNote(Note note) {
        JSONObject json = new JSONObject();
        try {
            int code = noteMapper.collecNote(note);
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

    //    更改笔记
    @Override
    public JSON updateNote(Note note) {
        JSONObject json = new JSONObject();
        try {
            int code = noteMapper.updateNote(note);
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

    //    删除笔记
    @Override
    public JSON deleteNote(int id) {
        JSONObject json = new JSONObject();
        try {
            int code = noteMapper.deleteNote(id);
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
