package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.dto.RacingDTO;
import PonyLand.PonyLand.service.GameService;
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

    @Autowired
    private GameService Gameservice;


    // 경마장으로 가는 코드
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
    
    //게임 설명 버튼 클릭시 게임설명 페이지 이동
    @RequestMapping("goGameExplain")
    public String gameExplain() throws Exception {
        return "gameExplain";
    }

    // 게임 실행 버튼 클릭시  그게 맞는 말 번호 실행 페이지로 이동
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
    public double estimatedAmount(int bettingCoin, int horseCount, String member_coin) {


        return service.add(bettingCoin, horseCount);
    }

    //게임 후 레이싱 결과화면으로 가는 코드
    @RequestMapping("goGameResult")
    public String goGameResult(String winner, Model model) throws Exception{
        String betNumber="";
        RacingDTO dto = new RacingDTO();
        dto = service.selectBet((String) session.getAttribute("sessionID"));

        //내가 배팅한 말 번호랑 , 승리한 말이랑 번호가 같을 경우 업데이트문 실행, 업데이트 문 실행 후 racing 테이블  dto delete 문 실행
        if (dto.getRacing_horse_seq().equals(winner)) {
            System.out.println("d여긴?");
            service.updateWin(dto);
            betNumber = dto.getRacing_horse_seq();
            service.deleteBet((String) session.getAttribute("sessionID"));

            //내가 배팅한 말 번호랑 , 승리한 말이랑 번호가 다를 경우 업데이트문 실행, 업데이트 문 실행 후 racing 테이블  dto delete 문 실행
        } else {
            System.out.println("d여긴??!?!??");
            service.updateLose(dto);
            betNumber = dto.getRacing_horse_seq();
            service.deleteBet((String) session.getAttribute("sessionID"));

        }
        System.out.println("위너 : " + winner);

        // 결과 화면에 승리 말 값이랑 배팅한 말 번호 가져가기 위한 코드
        String member_id = (String) session.getAttribute("sessionID");
        MemberDTO dto1 = service.findById(member_id);
        model.addAttribute("dto", dto1);
        model.addAttribute("winner", winner);
        model.addAttribute("betNumber", betNumber);

        return "gameResult";
    }
}