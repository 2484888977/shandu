package com.shandu.mapper;

import com.shandu.pojo.Music;
import com.shandu.pojo.Note_View;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MusicMapper {
    //    查询音乐
    List<Music> selectMusic(int page, int limit, String keyword);

    //    删除音乐
    int deleteMusic(int m_id);

    //     添加音乐
    int addMusic(Music music);

}
