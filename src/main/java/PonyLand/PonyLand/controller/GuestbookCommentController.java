package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/GuestbookComment/")
@Controller
public class GuestbookCommentController {

    @Autowired
    private GuestbookCommentService service;


    @RequestMapping("insert")
    public String insert(GuestbookCommentDTO dto,Model model)throws Exception{
        service.insert(dto);
        System.out.println("댓글 내용 : "+dto.getGuestbook_comment_contents());
        System.out.println("parent_seq : "+dto.getParent_seq());
        return"redirect:/Guestbook/goGuestbook?parent_seq="+dto.getParent_seq()+"";
    }

}
