package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
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
    public String gameStart(String id, Model model)  {
        model.addAttribute("id", id);
        model.addAttribute("dto",service.findById(id));
        return "gameStart";
    }

    @RequestMapping("goGameSetting")
    public String goGameSetting(Model model) throws Exception{
        String id=(String) session.getAttribute("sessionID");
        MemberDTO dto = service.findById(id);
        model.addAttribute("dto",dto);
        System.out.println(dto.getMember_coin());
        System.out.println(id);
        return "gameSetting";
    }


    @RequestMapping("goGameExplain")
    public String gameExplain() throws Exception {
        return "gameExplain";
    }


}