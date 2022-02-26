package com.shandu.controller;


import com.alibaba.fastjson.JSON;
import com.shandu.pojo.Proposal;
import com.shandu.service.ProposalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ProposalController")
@Api(tags = "建议与反馈相关接口")
public class ProposalController {
    @Autowired
    private ProposalService proposalService;

    //添加建议
    @GetMapping("/addProposal")
    @ResponseBody
    @CrossOrigin
    public JSON addProposal(Proposal proposal) {
        return proposalService.addProposal(proposal);
    }

    //查看建议
    @GetMapping("/selectProposal")
    @ResponseBody
    @CrossOrigin
    public JSON selectProposal(int page, int limit, String keyword) {
        return proposalService.selectProposal(page, limit, keyword);
    }
}
