package PonyLand.PonyLand.controller;


import PonyLand.PonyLand.dto.ItemDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.CoinService;
import PonyLand.PonyLand.service.ItemService;
import PonyLand.PonyLand.service.MemberService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stable/")
public class StableController {
    @Autowired
    private HttpSession session;
    @Autowired
    private CoinService service;


    @Autowired
    private MemberService service1;

    @Autowired
    private ItemService service2;

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

        @RequestMapping("toStable")
        public String toStable(Model model,String id){
            String horse = "horse";
            String bg = "background";
            String f = "furniture";
            model.addAttribute("id",id);
            model.addAttribute("dto",service1.findById(id));
            model.addAttribute("itemlist",service2.findHorseById(id));
            model.addAttribute("bglist",service2.findBgById(id));
            model.addAttribute("furniturelist",service2.findFurnitureById(id));
            model.addAttribute("nowdto", service2.findByItemStatus(id,horse));
            model.addAttribute("nowbgdto", service2.findByItemStatus(id,bg));
            model.addAttribute("nowfurniturelist", service2.findFurnitureByItemStatus(id,f));
            //model.addAttribute("nowbgdto", service2.findByItemStatus(id,f));
            return "stable";
        }


        @RequestMapping("update")
        @ResponseBody
        public String update(String imgSeq){

            System.out.println(imgSeq);
            ItemDTO dto = service2.findByItemSeq(imgSeq);
            String itemCategory = dto.getItemCategory();
            service2.updateItem(dto);
            service2.updateOtherStatus(imgSeq,itemCategory);

            Gson g = new Gson();
            String stringDto = g.toJson(dto);
            System.out.println(stringDto);
            return stringDto;
        }

    @RequestMapping("updateFurniture")
    @ResponseBody
    public String updateFurniture(String jsoncheckimgseq){

        System.out.println(jsoncheckimgseq);
        Gson g = new Gson();
        List list =g.fromJson(jsoncheckimgseq, ArrayList.class);
        System.out.println(service2.furnitureListControl(list));
        return g.toJson(service2.furnitureListControl(list));

    }

        @RequestMapping("coordinate")
        @ResponseBody
        public String coordinate(String x, String y){

            System.out.println(x);
            System.out.println(y);

            int intx = Integer.parseInt(x);
            int inty = Integer.parseInt(y);

            System.out.println(intx);
            System.out.println(inty);

            String itemCategory = "horse";

            String id =(String)session.getAttribute("sessionID");

            ItemDTO dto = service2.findByItemStatus(id,itemCategory);


            dto.setItemX(intx);
            dto.setItemY(inty);
            service2.updateCoordinate(dto);
            return "";
        }

    @RequestMapping("coordinateFurniture")
    @ResponseBody
    public String coordinateFurniture(String x, String y,String furnitureSeq){

//        System.out.println(x);
//        System.out.println(y);

        int intx = Integer.parseInt(x);
        int inty = Integer.parseInt(y);


//        System.out.println(intx);
//        System.out.println(inty);

        String itemCategory = "furniture";

        String id =(String)session.getAttribute("sessionID");

        ItemDTO dto = service2.findByItemSeq(furnitureSeq);


        dto.setItemX(intx);
        dto.setItemY(inty);
        service2.updateCoordinate(dto);
        return "";
    }


}