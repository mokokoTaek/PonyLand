package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.MemberService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping("currentCoin")
    public String currentCoin(String member_coin, String batting_coin) throws Exception {
        double currentCoin = service.currentCoin(Integer.parseInt(member_coin), Integer.parseInt(batting_coin));
        Gson g = new Gson();

        return g.toJson(currentCoin);
    }

    @ResponseBody
    @RequestMapping("expectCoin")
    public String expectCoin(String batting_coin, String horseCount) throws Exception {
        double expectCoin = service.expectCoin(Integer.parseInt(batting_coin), Integer.parseInt(horseCount));
        Gson g = new Gson();

        return g.toJson(expectCoin);
    }

    @RequestMapping("goGameRun")
    public String goGameRun() {
        return "gameRun";
    }
}