package com.zerobase.fastlms.admin;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.member.service.MemberService;
import com.zerobase.fastlms.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminMemberController {
    private final MemberService memberService;

    @GetMapping("/admin/member/list.do")
    public String list(Model model, MemberParam parameter){
        //parameter.init();
        parameter.Init();
        List<MemberDto> members=memberService.list(parameter);
        model.addAttribute("list",members);

        long totalcount=0;
        if (members!=null && members.size()>0)
            totalcount=members.get(0).getTotalCount();

        String queryString="";
        /*전체 회원 갯수*/

        PageUtil pageUtil=new PageUtil(totalcount, parameter.getPageSize(),parameter.getPageIndex(),queryString);
        model.addAttribute("pager",pageUtil.pager());

        return "admin/member/list";
    }


    /*이메일 폼 */
    @GetMapping("/admin/member/manage_emailForm.do")
    public String emailForm(Model mode){
        return "admin/member/emailform";
    }
}
