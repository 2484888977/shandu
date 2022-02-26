package com.shandu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.pojo.Music;
import com.shandu.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("MusicContorller")
@Api(tags = "音乐相关接口")
public class MusicContorller {

    @Autowired
    private MusicService musicService;

    //    查询音乐
    @GetMapping("/selectMsic")
    @ResponseBody
    @CrossOrigin
    public JSON selectMsic(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", musicService.selectMusic(0, 10000, keyword).size());
        json.put("data", musicService.selectMusic(page2, limit, keyword));
        return json;
    }
    //    查询全部音乐
    @GetMapping("/selectMsicInfo")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="查询所有音乐", notes="无需传参")
    public JSON selectMsicInfo() {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", musicService.selectMusic(0, 10000, null).size());
        json.put("data", musicService.selectMusic(0, 10000, null));
        return json;
    }
    //删除音乐
    @GetMapping("/deleteMusic")
    @ResponseBody
    @CrossOrigin
    public JSON deleteMusic(int m_id) {
        return musicService.deleteMusic(m_id);
    }
    //添加音乐
    @GetMapping("/addMusic")
    @ResponseBody
    @CrossOrigin
    public JSON addMusic(Music music) {
        return musicService.addMusic(music);
    }
}
