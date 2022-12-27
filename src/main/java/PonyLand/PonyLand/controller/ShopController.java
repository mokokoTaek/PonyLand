package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.ItemDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.ItemService;
import PonyLand.PonyLand.service.MemberService;
import PonyLand.PonyLand.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop/")
public class ShopController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private HttpSession session;

    @RequestMapping("toShop")
    public String toShop(Model model){
        String id = (String)session.getAttribute("sessionID");
        model.addAttribute("memberdto",memberService.findById(id));
        return "shop";
    }

    @RequestMapping("buy")
    @ResponseBody
    public Boolean buy(String product, String price, String category){

        String id = (String)session.getAttribute("sessionID");

        MemberDTO memberDto =memberService.findById(id);

        Boolean result = shopService.buy(memberDto,price,product,category);


        return result;
    }

    @RequestMapping("wish")
    @ResponseBody
    public int wish(String product, String price){
        return shopService.wish(product, price);
    }

}
