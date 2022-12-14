package PonyLand.PonyLand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/toMiniPage")
    public String miniHome(String id, Model model){
        model.addAttribute("id",id);
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


}
