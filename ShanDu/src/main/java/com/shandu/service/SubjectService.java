package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Major;
import com.shandu.pojo.Subject;

public interface SubjectService {
    //    查询对应专业下全部学科
    JSON selectSubject(int majorid);

    //    查询专业
    JSON selectSubject01(int page, int limit, String keyword);

    //    添加专业
    JSON addSubject(Subject subject);

    //    修改专业
    JSON updateSubject(Subject subject);

    //    删除专业
    JSON deleteSubject(int s_id);
}
