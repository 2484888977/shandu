package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Proposal;

public interface ProposalService {
    //    添加建议
    JSON addProposal(Proposal proposal);
    //    查询建议
    JSON selectProposal(int page, int limit, String keyword);
}
