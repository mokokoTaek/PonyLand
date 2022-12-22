package PonyLand.PonyLand.controller;


import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stable/")
public class StableController {
    @Autowired
    private HttpSession session;
    @Autowired
    private CoinService service;

    @RequestMapping("charge")
    public String charge(MemberDTO dto, Model model){
        String id = session.getAttribute("sessionID").toString();
        dto.setMember_coin(service.selectByOne(id));
        System.out.println(dto.getMember_coin());
        int coin = dto.getMember_coin();
        System.out.println(id + ":" + coin);
        model.addAttribute("coin", coin);
        return "carrot";
    }

    @PostMapping("purchase")
    public String handlePurchase(@RequestParam int amount, MemberDTO dto, Model model) {
        String id = session.getAttribute("sessionID").toString();
        System.out.println(id + "Received amount: " + amount);
        int coin;
        if (amount == 1000){
            dto.setMember_coin(10);
            coin = dto.getMember_coin();
            System.out.println(coin);
        } else if (amount == 2000){
            dto.setMember_coin(20);
            coin = dto.getMember_coin();
            System.out.println(coin);
        }else if (amount == 3000){
            dto.setMember_coin(32);
            coin = dto.getMember_coin();
            System.out.println(coin);
        }else if (amount == 5000){
            dto.setMember_coin(55);
            coin = dto.getMember_coin();
            System.out.println(coin);
        }else if (amount == 10000){
            dto.setMember_coin(115);
            coin = dto.getMember_coin();
            System.out.println(coin);
        }else if (amount == 30000){
            dto.setMember_coin(350);
            coin = dto.getMember_coin();
            System.out.println(coin);
        }
        return "carrot";
    }


    @PostMapping("purchase2")
    public String handlePurchase2(@RequestParam int amount, MemberDTO dto) {
        System.out.println("결제금액: " + amount);
        int coin;
        String id = session.getAttribute("sessionID").toString();
        switch (amount) {
            case 1000:
                dto.setMember_coin(10);
                break;
            case 2000:
                dto.setMember_coin(20);
                break;
            case 3000:
                dto.setMember_coin(32);
                break;
            case 5000:
                dto.setMember_coin(55);
                break;
            case 10000:
                dto.setMember_coin(115);
                break;
            case 30000:
                dto.setMember_coin(350);
                break;
            default:
                // handle other values of amount
        }
        coin = dto.getMember_coin();
        System.out.println(id);
        System.out.println(coin);
        System.out.println(id + "계정의" + coin + "코인이 충전 되었습니다.");
        service.setCoin(coin, id);
        return "redirect:/carrot";
    }
}