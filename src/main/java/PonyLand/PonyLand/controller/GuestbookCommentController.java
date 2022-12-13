package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/GuestbookComment/")
@Controller
public class GuestbookCommentController {

    @Autowired
    private GuestbookCommentService service;


    @RequestMapping("insert")
    public String insert(GuestbookCommentDTO dto)throws Exception{
        service.insert(dto);
        System.out.println(dto.getGuestbook_comment_contents());
        return"";
    }

}
