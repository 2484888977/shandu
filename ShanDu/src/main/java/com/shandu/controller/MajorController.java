package com.shandu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.MajorMapper;
import com.shandu.pojo.Major;
import com.shandu.service.MajorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("MajorController")
@Api(tags = "专业相关接口")
public class MajorController {

    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private MajorService majorService;

    //查看专业
    @GetMapping("/selectMajor")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有专业", notes = "无需传参")
    public JSON selectMajor() {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", majorMapper.selectMajor().size());
        json.put("data", majorMapper.selectMajor());
        return json;
    }

    //    查询专业
    @GetMapping("/selectMajor01")
    @ResponseBody
    @CrossOrigin
    public JSON selectMajor01(int page, int limit, String keyword) {
        return majorService.selectMajor01(page, limit, keyword);
    }

    //    添加专业
    @GetMapping("/addMajor")
    @ResponseBody
    @CrossOrigin
    public JSON addMajor(String majorinfo) {
        return majorService.addMajor(majorinfo);
    }

    //    修改专业
    @GetMapping("/updateMajor")
    @ResponseBody
    @CrossOrigin
    public JSON updateMajor(Major major) {
        return majorService.updateMajor(major);
    }
    //    删除专业
    @GetMapping("/deleteMajor")
    @ResponseBody
    @CrossOrigin
    public JSON deleteMajor(int majorid) {
        return majorService.deleteMajor(majorid);
    }
}
