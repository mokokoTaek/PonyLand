package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dao.MemberDAO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.MemberService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/")
public class MemberController {

    @Autowired
    MemberService service;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletResponse response;
    @GetMapping("wave")

    @RequestMapping("wave")
    public String getWave(Model model){

        Long countMember = service.getWave();
        int randomNumber = service.getRandom(countMember);
        System.out.println(randomNumber);

        String id = service.toWave(randomNumber);
        model.addAttribute("id",id);
        return "main";
    }
    @PostMapping("insert")
    public String insert(MemberDTO dto){
        service.insert(dto);
        return "redirect:/";
    }

    @RequestMapping("login")
    public String login(MemberDTO dto, Model model) throws Exception{
        service.login(dto.getMemberId(), dto.getMemberPw());
        session.setAttribute("sessionID", dto.getMemberId());
        System.out.println(session.getAttribute("sessionID"));
        model.addAttribute("id", dto.getMemberId());
        System.out.println(dto.getMemberId());
        return "index";
    }

    @GetMapping ("logout")
    public void logout() throws Exception{
        service.logout();
    }

    @RequestMapping("signinForKakao")
    public String signinForKakao(String email,Model model){

        MemberDTO dto = service.makeIdAndPwByEmail(email);
        model.addAttribute("id",dto.getMemberId());
        return "index";
    }


}
