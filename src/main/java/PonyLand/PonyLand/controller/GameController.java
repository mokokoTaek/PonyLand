package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.dto.RacingDTO;
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
    public String gameRun(String id, int bettingCoin, int horseCount, String betHorse) throws Exception{
        System.out.println(bettingCoin + id + betHorse);
        System.out.println(horseCount);
        service.bettingCoin(id, bettingCoin, horseCount, betHorse);
        return "gameRun" + horseCount;
    }


    // ajax 실시간 배팅예상 금액 코드
    @ResponseBody
    @RequestMapping("estimatedAmount")
    public double estimatedAmount(int bettingCoin, int horseCount) {

        return service.add(bettingCoin, horseCount);
    }


    @RequestMapping("goGameResult")
    public String goGameResult(String winner, Model model) throws Exception{
        String betNumber="";
        RacingDTO dto = new RacingDTO();
        dto = service.selectBet((String) session.getAttribute("sessionID"));

        if (dto.getRacing_horse_seq().equals(winner)) {
            System.out.println("d여긴?");
            service.updateWin(dto);
            betNumber = dto.getRacing_horse_seq();
            service.deleteBet((String) session.getAttribute("sessionID"));


        } else {
            System.out.println("d여긴??!?!??");
            service.updateLose(dto);
            betNumber = dto.getRacing_horse_seq();
            service.deleteBet((String) session.getAttribute("sessionID"));

        }
        System.out.println("위너 : " + winner);

        // 결과 화면에 값 뿌려주기 위한 코드
        String member_id = (String) session.getAttribute("sessionID");
        MemberDTO dto1 = service.findById(member_id);
        model.addAttribute("dto", dto1);
        model.addAttribute("winner", winner);
        model.addAttribute("betNumber", betNumber);

        return "gameResult";
    }


}