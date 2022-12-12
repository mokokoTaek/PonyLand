package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dao.MemberDAO;
import PonyLand.PonyLand.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {

    @Autowired
    MemberService service;

    @GetMapping("wave")
    public String getWave(){

        Long countMember = service.getWave();
        int randomNumber = service.getRandom(countMember);


        return "redirect:/toMiniPage";
    }
}
