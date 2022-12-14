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
    public String getWave(){

        Long countMember = service.getWave();
        int randomNumber = service.getRandom(countMember);
        System.out.println(randomNumber);

        String id = service.toWave(randomNumber);

        return "redirect:/toMiniPage?id="+id+"";
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
        model.addAttribute("id", dto.getMemberId());
        System.out.println(dto.getMemberId());
        return "index";
    }

    @GetMapping ("logout")
    public void logout() throws Exception{
        session.invalidate();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('로그아웃 되었습니다.'); location.href='/';</script>");
        out.flush();
        response.flushBuffer();
        out.close();
    }

    @RequestMapping("signinForKakao")
    public String signinForKakao(String id, String email){

        return "singinForKakao";
    }




}
