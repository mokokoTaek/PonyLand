package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@RequestMapping("/GuestbookComment/")
@Controller
public class GuestbookCommentController {

    @Autowired
    private GuestbookCommentService service;

    @Autowired
    private HttpSession session;

    @Autowired
    private Gson g;

    @ResponseBody
    @RequestMapping("insert")
    public String commentFrm(String parent_seq, String guestbook_comment_contents) {
        Gson g = new Gson();
        String Guestbook_comment_writer = (String) session.getAttribute("sessionID");
        GuestbookCommentDTO GuestbookCommentDto = new GuestbookCommentDTO(0,Guestbook_comment_writer,guestbook_comment_contents,null,Integer.parseInt(parent_seq));
        service.insert(GuestbookCommentDto);

        System.out.println("0102일 questbook_comment_seq 값 : " +  GuestbookCommentDto.getGuestbook_comment_seq());

        return g.toJson(service.selectComment(GuestbookCommentDto.getGuestbook_comment_seq()));
    }

    @RequestMapping("delete")
    public String guestbook_comment_delete(int guestbook_comment_seq, String host){
        service.delete(guestbook_comment_seq);
        return "redirect:/Guestbook/goGuestbook?&guestbook_host="+host;
    }
}
