package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.CommentMapper;
import com.shandu.mapper.MajorMapper;
import com.shandu.pojo.Major;
import com.shandu.pojo.Note_View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    //    查询专业
    @Override
    public JSON selectMajor01(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", majorMapper.selectMajor01(0, 10000, keyword).size());
        json.put("data", majorMapper.selectMajor01(page2, limit, keyword));
        return json;
    }

    //    添加专业
    @Override
    public JSON addMajor(String majorinfo) {
        JSONObject json = new JSONObject();
        try {
            int code = majorMapper.addMajor(majorinfo);
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
    //    修改专业
    @Override
    public JSON updateMajor(Major major) {
        JSONObject json = new JSONObject();
        try {
            int code = majorMapper.updateMajor(major);
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

    //    删除专业
    @Override
    public JSON deleteMajor(int majorid) {
        JSONObject json = new JSONObject();
        try {
            int code = majorMapper.deleteMajor(majorid);
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
