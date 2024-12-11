
package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Member;
import com.example.service.MemberService;

@Controller
@RequestMapping(value = "members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/getPageMemberAdd", method = RequestMethod.GET)
    private ModelAndView getPageMemberAdd() {
        ModelAndView view = new ModelAndView("addMember");
        view.addObject("member", new Member());
        return view;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addMember(@ModelAttribute("member") Member member) {
        memberService.saveMember(member);
        return "redirect:/members/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateMember(@ModelAttribute("member") Member member) {
        memberService.updateMember(member);
        return "redirect:/members/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView view = new ModelAndView("homePage");
        List<Member> data = memberService.list();
        view.addObject("datas", data);
        return view;
    }

    @RequestMapping(value = "/memberDelete/{id}")
    public String delete(@PathVariable("id") int id) {
        memberService.removeMember(id);
        return "redirect:/members/list";
    }

    @RequestMapping("/edit/{id}")
    public String editMember(@PathVariable("id") int id, Model model) {
        model.addAttribute("member", this.memberService.getMember(id));
        return "editMember";
    }
}
