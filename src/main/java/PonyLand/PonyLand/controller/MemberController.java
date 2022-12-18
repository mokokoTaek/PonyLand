package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String getWave(Model model,HttpServletRequest request, HttpServletResponse response){

        Long countMember = service.getWave();
        int randomNumber = service.getRandom(countMember);

        String id = service.toWave(randomNumber);
        System.out.println("!!!!");
        System.out.println(id);
        service.addView(id,request,response);

        MemberDTO dto = service.findById(id);

        model.addAttribute("dto",dto);
        model.addAttribute("id",id);
        model.addAttribute("sessionID",session.getAttribute("sessionID"));
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
//        System.out.println(session.getAttribute("sessionID"));
        model.addAttribute("id", dto.getMemberId());
        System.out.println(dto.getMemberId());
        return "index";
    }


    @GetMapping ("logout")
    public String logout() throws Exception{
        service.logout();
        return "index";
    }

    @RequestMapping("signinForKakao")
    public String signinForKakao(String name,String email,Model model){

        MemberDTO dto = service.makeIdAndPwByEmailForKakao(name,email);
        model.addAttribute("id",dto.getMemberId());
        return "index";
    }

    @RequestMapping("areYouKakao")
    @ResponseBody
    public String areYouKakao(String id){
        return service.findById(id).getMemberLoginType();
    }


    @RequestMapping("signinForNaver")
    public String singinForNaver(Model model, String name, String email){

        MemberDTO dto =service.makeIdAndPwByEmailForNaver(name,email);
       model.addAttribute("id",dto.getMemberId());

        return "index";
    }





}
