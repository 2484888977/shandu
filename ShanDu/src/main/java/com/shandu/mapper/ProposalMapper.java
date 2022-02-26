package com.shandu.mapper;

import com.shandu.pojo.Proposal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProposalMapper {
//    添加建议
    int addProposal(Proposal proposal);
//    查询建议
    List<Proposal> selectProposal(int page, int limit, String keyword);
}
