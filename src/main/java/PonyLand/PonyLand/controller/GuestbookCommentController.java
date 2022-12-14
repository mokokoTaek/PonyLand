package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/GuestbookComment/")
@Controller
public class GuestbookCommentController {

    @Autowired
    private GuestbookCommentService service;


    @RequestMapping("insert")
    public String insert(GuestbookCommentDTO dto)throws Exception{
        service.insert(dto);
        System.out.println(dto.getGuestbook_comment_contents());
        return"redirect:/Guestbook/goGuestbook";
       /* return"redirect:select";   *//* 이게 select 한 다음 해야하는 코드*/
    }

    @RequestMapping("select")
    public String select(Model model,int parent_seq) {
        List<GuestbookCommentDTO> list = service.select(parent_seq);
        model.addAttribute("dto1",list);

        return"redirect:/Guestbook/goGuestbook";
    }


}
