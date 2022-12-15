package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String commentFrm(String seq, String content) { //String 형이야
        GuestbookCommentDTO dto = new GuestbookCommentDTO();
        dto.setGusetbook_comment_seq(Integer.parseInt(seq));
        dto.setGuestbook_comment_contents(content);
        service.insert(dto);

        List<GuestbookCommentDTO> list = service.select(Integer.parseInt(seq));

        String s = g.toJson(list);

        return s;
    }
}
