package PonyLand.PonyLand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/game/")
public class GameController {
    @Autowired
    private HttpSession session;

    @RequestMapping("gameStart")
    public String gameStart() throws Exception {
        return "gameStart";
    }

    @RequestMapping("goGameSetting")
    public String goGameSetting() throws Exception{
        return "gameSetting";
    }


    @RequestMapping("goGameExplain")
    public String gameExplain() throws Exception {
        return "gameExplain";
    }


}