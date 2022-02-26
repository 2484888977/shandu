package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Note;
import com.shandu.pojo.Note_View;

import java.util.List;

public interface NoteService {
    //    添加笔记
    JSON addNote(Note note);

    //    查询笔记
    List<Note_View> selectNote(int page, int limit, String keyword);

    //    查询对应专业学科笔记
    JSON selectNoteMajor(int page, int limit, int subjectid);

    //    笔记id查询笔记
    JSON selectNoteNId(int id);

    //    查询推荐笔记
    JSON selectNoteTuiJ(int page, int limit, String keyword);

    //    笔记变推荐笔记/推荐笔记变笔记
    JSON updateNote01(Note note);
//    收藏笔记
    JSON collecNote(Note note);

    //    更改笔记
    JSON updateNote(Note note);

    // 删除笔记
    JSON deleteNote(int id);
}
