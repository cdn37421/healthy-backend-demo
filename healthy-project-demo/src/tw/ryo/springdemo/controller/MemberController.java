package tw.ryo.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.ryo.springdemo.entity.Member;
import tw.ryo.springdemo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	// need to inject our Member service
	@Autowired
	private MemberService MemberService;

	@GetMapping("/list")
	public String listMember(Model theModel) {

		// get Members from the service
		List<Member> theMembers = MemberService.getMembers();

		// add the Members to the model
		theModel.addAttribute("members", theMembers);

		return "list-members";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Member theMember = new Member();

		theModel.addAttribute("member", theMember);

		return "member-form";
	}

	@PostMapping("/saveMember")
	public String saveMember(@ModelAttribute("member") Member theMember) {

		// save the Member using our service

		MemberService.saveMember(theMember);
		return "redirect:/member/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("memberId") int theId, Model theModel) {

		// get the Member from the service
		Member theMember = MemberService.getMembers(theId);
		
		// set Member as a model attribute to pre-populate the form
		theModel.addAttribute("member", theMember);
		// send over to our form
		
		return "member-form";
	}

	@GetMapping("/delete")
	public String deleteMember(@RequestParam("memberId") int theId) {
		
		
		//delete the Member
		MemberService.deleteMember(theId);
		return "redirect:/member/list";
	}
}
