package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import PonyLand.PonyLand.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Guestbook/")
public class GuestbookController {

    @Autowired
    private GuestbookService service;

    @Autowired
    private GuestbookCommentService service1;


    @GetMapping("insert")
    public String insert(GuestbookDTO dto) throws Exception {

        service.insert(dto);
        System.out.println(dto.getGuestbook_contents());
        return "redirect:goGuestbook";
    }

    @RequestMapping("delete")
    public String delete(int Guestbook_seq){
        service.delect(Guestbook_seq);
        System.out.println(Guestbook_seq);
        return "redirect:goGuestbook";
    }

    @RequestMapping("update")
    public String update(GuestbookDTO dto){
        service.update(dto);
        return "guestbook";
    }

    //미니홈피에서 방명록으로 가는 코트
    @RequestMapping("goGuestbook")
    public String goGuestbook(Model model) {
        List<GuestbookDTO> list = service.select();

        model.addAttribute("dto",list);

        return "guestbook";}


    //방명록에서 글작성으로 가는 코드
    @RequestMapping("gowrite")
    public String gowrite(){return  "guesbookwrite";}
}
