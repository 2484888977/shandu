package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.CommentMapper;
import com.shandu.mapper.MajorMapper;
import com.shandu.mapper.MusicMapper;
import com.shandu.pojo.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    //    查询音乐
    @Override
    public List<Music> selectMusic(int page, int limit, String keyword) {
        return musicMapper.selectMusic(page, limit, keyword);
    }

    //删除音乐
    @Override
    public JSON deleteMusic(int m_id) {
        JSONObject json = new JSONObject();
        try {
            int code = musicMapper.deleteMusic(m_id);
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

    // 添加音乐
    @Override
    public JSON addMusic(Music music) {
        JSONObject json = new JSONObject();
        try {
            int code = musicMapper.addMusic(music);
            if (code == 1) {
                json.put("code", 1);
                json.put("msg", "添加信息成功");
            } else {
                json.put("code", 0);
                json.put("msg", "添加信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("msg", "数据接口异常，请稍后重试");
            json.put("code", -1);
        }
        return json;
    }
}
