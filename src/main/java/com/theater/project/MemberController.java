package com.theater.project;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.theater.member.CompanyDTO;
import com.theater.member.MemberDTO;
import com.theater.member.MemberService;
import com.theater.member.UserDTO;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public String memberJoin(){
		return "member/memberJoin";
	}
	
	/*@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(RedirectAttributes attributes, MemberDTO memberDTO) throws Exception {
		int result = memberService.memberJoin(memberDTO);
		System.out.println(memberDTO.getKind());
		String message="FAIL";
		if(result>0){
			message="SUCCESS";
		}
		attributes.addFlashAttribute("message", message);
		return "redirect:/";
	}*/
	
	@RequestMapping(value="/user/memberJoin", method=RequestMethod.POST)
	public String memberJoinUser(RedirectAttributes attributes, MemberDTO memberDTO, UserDTO userDTO) throws Exception {
		System.out.println(userDTO.getBirth());
		int result = memberService.memberJoin(memberDTO);
		result = memberService.userJoin(userDTO);
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getKind());
		String message="FAIL";
		if(result>0){
			message="SUCCESS";
		}
		attributes.addFlashAttribute("message", message);
		return "redirect:/";
	}
	
	@RequestMapping(value="/company/memberJoin", method=RequestMethod.POST)
	public String memberJoinCompany(RedirectAttributes attributes, MemberDTO memberDTO, CompanyDTO companyDTO) throws Exception {
		int result = memberService.memberJoin(memberDTO);
		result = memberService.companyJoin(companyDTO);
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getKind());
		String message="FAIL";
		if(result>0){
			message="SUCCESS";
		}
		attributes.addFlashAttribute("message", message);
		return "redirect:/";
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void membrLogin(){}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session){
		try {
			memberDTO=memberService.login(memberDTO);
		} catch (Exception e) {
			memberDTO=null;
			e.printStackTrace();
		}
		if(memberDTO != null){
			session.setAttribute("member", memberDTO);
		}
		return "redirect:/";	
	}
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
