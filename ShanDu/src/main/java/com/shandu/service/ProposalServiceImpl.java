package com.shandu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shandu.mapper.ProposalMapper;
import com.shandu.pojo.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalServiceImpl implements ProposalService{

    @Autowired
    private ProposalMapper proposalMapper;
//    添加建议
    @Override
    public JSON addProposal(Proposal proposal) {
        JSONObject json = new JSONObject();
        try {
            int code = proposalMapper.addProposal(proposal);
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
//    查询建议
    @Override
    public JSON selectProposal(int page, int limit, String keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "");
        json.put("count", proposalMapper.selectProposal(0, 10000, keyword).size());
        json.put("data", proposalMapper.selectProposal(page2, limit, keyword));
        return json;
    }
}
