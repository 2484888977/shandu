package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Major;

public interface MajorService {
    //    查询专业
    JSON selectMajor01(int page, int limit, String keyword);

    //    添加专业
    JSON addMajor(String majorinfo);

    //    修改专业
    JSON updateMajor(Major major);

    //    删除专业
    JSON deleteMajor(int majorid);
}
