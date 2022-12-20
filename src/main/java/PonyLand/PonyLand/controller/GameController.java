package PonyLand.PonyLand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MiniGame/")
public class GameController {

    @Autowired
    private HttpSession session;

    @RequestMapping("goGame")
    public String goGame(){
        return "gameStart";
    }

}
