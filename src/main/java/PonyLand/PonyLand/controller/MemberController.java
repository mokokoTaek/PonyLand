package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dao.MemberDAO;
import PonyLand.PonyLand.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/")
public class MemberController {

    @Autowired
    HttpSession session;

    @Autowired
    MemberService service;

    @RequestMapping("wave")
    public String getWave(){

        Long countMember = service.getWave();
        int randomNumber = service.getRandom(countMember);
        System.out.println(randomNumber);

        String id = (String) session.getAttribute("loginID");

        return "redirect:/toMiniPage";
    }


}
