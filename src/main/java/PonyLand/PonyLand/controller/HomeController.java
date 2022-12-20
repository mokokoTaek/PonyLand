package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private HttpSession session;

    @Autowired
    private MemberService service;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/toMiniPage")
    public String miniHome(String id, Model model){

        MemberDTO dto =service.findById(id);

        model.addAttribute("dto",dto);
        model.addAttribute("id",id);
        model.addAttribute("sessionID",session.getAttribute("sessionID"));
        model.addAttribute("list",dto);
        return "main";
    }

    @GetMapping("/stable")
    public String stable(){return "stable";}

    @GetMapping("/toAlbumPage")
    public String AlbumPage(){
        return "album";
    }

    @GetMapping("/signin")
    public String insert(){
        return "signin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/toFamilyOpen")
    public String toFamilyOpen(){return "familyOpen";}

    @GetMapping("/toCheckNewFamilyOpen")
    public String toCheckNewFamilyOpen(){return "checkNewFamilyOpen";}

    @RequestMapping("/toFamilyListOpen")
    public String toFamilyListOpen(){return "redirect:/family/familyListOpen";}

    @RequestMapping("/stable")
    public String toStable(String id, Model model){
        model.addAttribute("id",id);
        model.addAttribute("dto",service.findById(id));
        return "stable";
    }
}
