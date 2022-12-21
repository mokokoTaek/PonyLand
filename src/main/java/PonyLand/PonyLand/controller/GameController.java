package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.GameService;
import PonyLand.PonyLand.service.MemberService;
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

    @Autowired
    private GameService Gameservice;


    @RequestMapping("gameStart")
    public String gameStart() {
        return "gameStart";
    }

    @RequestMapping("goGameSetting")
    public String goGameSetting(Model model) throws Exception {
        String member_id = (String) session.getAttribute("sessionID");
        MemberDTO dto = service.findById(member_id);
        model.addAttribute("dto", dto);
        return "gameSetting";
    }


    @RequestMapping("goGameExplain")
    public String gameExplain() throws Exception {
        return "gameExplain";
    }

    @RequestMapping("gameRun")
    public String gameRun(String id, int bettingCoin, int horseCount) {
        System.out.println(bettingCoin+id);
        System.out.println(horseCount);
        service.coinUpdate(id,bettingCoin,horseCount);
        return "gameRun"+horseCount;
    }


    @ResponseBody
    @RequestMapping("estimatedAmount")
    public double estimatedAmount(int bettingCoin,int horseCount){

        return service.add(bettingCoin,horseCount);
    }


    @RequestMapping("goGameResult")
    public String goGameResult(int winner){
      /*  MemberDTO dto = service.selectMyBetHorseAndCoin//db 에 배팅한 말,코인 숫자 꺼내옴
        if(dto.get == winner){
            return "돈 딴거 db에 입력";
        }else{
            return "배팅한 금액 db에서 뻄";
        }
        System.out.println("위너"+winner);*/
        return "gameResult";
    }


}