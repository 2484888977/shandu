package com.shandu.mapper;

import com.shandu.pojo.Note;
import com.shandu.pojo.Note_View;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoteMapper {
    //    添加笔记
    int addNote(Note note);

    //    查询笔记
    List<Note_View> selectNote(int page, int limit, String keyword);

    //    查询推荐笔记
    List<Note_View> selectNoteTuiJ(int page, int limit, String keyword);

    //    笔记变推荐笔记/推荐笔记变笔记
    int updateNote01(Note note);

    //    查询对应专业学科笔记
    List<Note_View> selectNoteMajor(int page, int limit, int subjectid);

    //    用户id查询笔记
    List<Note_View> selectNoteId(int u_id);

    //    笔记id查询笔记
    List<Note_View> selectNoteNId(int id);

    //    用户查询收藏笔记
    List<Note_View> selectNoteIdColl(int collecid);

    //    更改笔记
    int updateNote(Note note);

    //    收藏/取消收藏 笔记
    int collecNote(Note note);

    //添加评论，评论数+1
    int updateNote02(int comnum, int id);

    //    删除笔记
    int deleteNote(int id);
}
