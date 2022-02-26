package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.SubjectMapper;
import com.shandu.mapper.UserMapper;
import com.shandu.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    //查询对应专业下全部学科
    @Override
    public JSON selectSubject(int majorid) {
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count", subjectMapper.selectSubject(majorid).size());
        json.put("data", subjectMapper.selectSubject(majorid));
        return json;
    }

    //    查询学科
    @Override
    public JSON selectSubject01(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", subjectMapper.selectSubject01(0, 10000, keyword).size());
        json.put("data", subjectMapper.selectSubject01(page2, limit, keyword));
        return json;
    }

    //    添加学科
    @Override
    public JSON addSubject(Subject subject) {
        JSONObject json = new JSONObject();
        try {
            int code = subjectMapper.addSubject(subject);
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
    //    修改学科
    @Override
    public JSON updateSubject(Subject subject) {
        JSONObject json = new JSONObject();
        try {
            int code = subjectMapper.updateSubject(subject);
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
    //    删除学科
    @Override
    public JSON deleteSubject(int s_id) {
        JSONObject json = new JSONObject();
        try {
            int code = subjectMapper.deleteSubject(s_id);
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
