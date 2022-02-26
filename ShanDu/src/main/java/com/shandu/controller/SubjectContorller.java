package com.shandu.controller;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Major;
import com.shandu.pojo.Subject;
import com.shandu.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("SubjectContorller")
@Api(tags = "学科相关接口")
public class SubjectContorller {
    @Autowired
    private SubjectService subjectService;

    //查询对应专业下全部学科
    @GetMapping("/selectSubject")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询对应专业下全部学科", notes = "无需传参")
    public JSON selectSubject(int majorid) {
        return subjectService.selectSubject(majorid);
    }

    //    查询学科
    @GetMapping("/selectSubject01")
    @ResponseBody
    @CrossOrigin
    public JSON selectSubject01(int page, int limit, String keyword) {
        return subjectService.selectSubject01(page, limit, keyword);
    }

    //    添加学科
    @GetMapping("/addSubject")
    @ResponseBody
    @CrossOrigin
    public JSON addSubject(Subject subject) {
        return subjectService.addSubject(subject);
    }

    //    修改学科
    @GetMapping("/updateSubject")
    @ResponseBody
    @CrossOrigin
    public JSON updateSubject(Subject subject) {
        return subjectService.updateSubject(subject);
    }

    //    删除学科
    @GetMapping("/deleteSubject")
    @ResponseBody
    @CrossOrigin
    public JSON deleteSubject(int s_id) {
        return subjectService.deleteSubject(s_id);
    }
}
