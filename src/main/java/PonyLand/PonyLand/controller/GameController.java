package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/game/")
public class GameController {
    @Autowired
    private HttpSession session;

    @Autowired
    private MemberService service;


    @RequestMapping("gameStart")
    public String gameStart()  {
        return "gameStart";
    }

    @RequestMapping("goGameSetting")
    public String goGameSetting(Model model) throws Exception{
        String member_id = (String)session.getAttribute("sessionID");
        MemberDTO dto = service.findById(member_id);
        model.addAttribute("dto",dto);
        return "gameSetting";
    }


    @RequestMapping("goGameExplain")
    public String gameExplain() throws Exception {
        return "gameExplain";
    }


}