package PonyLand.PonyLand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/toMiniPage")
    public String miniHome(){
        return "main";
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
