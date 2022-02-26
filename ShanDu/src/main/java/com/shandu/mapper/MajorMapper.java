package com.shandu.mapper;

import com.shandu.pojo.Major;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MajorMapper {
    //    查看专业
    List<Major> selectMajor();

    //    查询专业
    List<Major> selectMajor01(int page, int limit, String keyword);

    //    添加专业
    int addMajor(String majorinfo);

    //    修改专业
    int updateMajor(Major major);

    //    删除专业
    int deleteMajor(int Majorid);
}
