package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.ItemDTO;
import PonyLand.PonyLand.service.ItemService;
import PonyLand.PonyLand.service.MemberService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stable/")
public class StableController {

    @Autowired
    private HttpSession session;

    @Autowired
    private MemberService service1;

    @Autowired
    private ItemService service2;


    @RequestMapping("toStable")
    public String toStable(Model model,String id){

        model.addAttribute("id",id);
        model.addAttribute("dto",service1.findById(id));
        model.addAttribute("itemlist",service2.findHorseById(id));
        model.addAttribute("nowdto", service2.findByItemStatus(id));
        return "stable";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(String imgSeq){

        System.out.println(imgSeq);
        ItemDTO dto = service2.findByItemSeq(imgSeq);
        service2.updateItem(dto);
        service2.updateOtherStatus(imgSeq);

        Gson g = new Gson();
        String stringDto = g.toJson(dto);
        System.out.println(stringDto);
        return stringDto;
    }

    @RequestMapping("coordinate")
    @ResponseBody
    public String coordinate(String x, String y){
        int intx = Integer.parseInt(x);
        int inty = Integer.parseInt(y);

        String id =(String)session.getAttribute("sessionID");
        System.out.println(id);
        ItemDTO dto = service2.findByItemStatus(id);

        dto.setItemX(intx);
        dto.setItemY(inty);
        service2.updateCoordinate(dto);
        return "";
    }

}
