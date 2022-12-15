package PonyLand.PonyLand.controller;

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

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/toMiniPage")
    public String miniHome(String id, Model model){
        model.addAttribute("id",id);
        model.addAttribute("sessionID",session.getAttribute("sessionID"));
        return "main";
    }


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
}
