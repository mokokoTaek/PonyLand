package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
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
    @RequestMapping("commentFrm")
    public String commentFrm(String parent_seq, String guestbook_comment_contents) { //String 형이야

        String Guestbook_comment_writer = (String) session.getAttribute("sessionID");

        GuestbookCommentDTO dto = new GuestbookCommentDTO();

        dto.setGuestbook_comment_writer(Guestbook_comment_writer);
        dto.setParent_seq(Integer.parseInt(parent_seq));
        dto.setGuestbook_comment_contents(guestbook_comment_contents);
        service.insert(dto);

        String s = g.toJson(dto);

        return s;
    }
}
