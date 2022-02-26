package com.shandu.mapper;

import com.shandu.pojo.Major;
import com.shandu.pojo.Subject;
import com.shandu.pojo.Subject_View;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectMapper {

    //    查询对应专业下全部学科
    List<Subject> selectSubject(int majorid);

    //    查询学科
    List<Subject_View> selectSubject01(int page, int limit, String keyword);

    //    添加学科
    int addSubject(Subject subject);

    //    修改学科
    int updateSubject(Subject subject);

    //    删除学科
    int deleteSubject(int s_id);
}
