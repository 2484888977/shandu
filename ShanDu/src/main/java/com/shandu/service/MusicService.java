package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Music;
import com.sun.prism.j2d.J2DPipeline;

import java.util.List;

public interface MusicService {
    //    查询音乐
    List<Music> selectMusic(int page, int limit, String keyword);

    //    删除音乐
    JSON deleteMusic(int m_id);
//    添加音乐
    JSON addMusic(Music music);
}
