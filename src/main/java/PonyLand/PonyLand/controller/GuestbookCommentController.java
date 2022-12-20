package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import PonyLand.PonyLand.service.GuestbookService;
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
    private GuestbookService GuestbookService;

    @Autowired
    private GuestbookCommentService service;

    @Autowired
    private HttpSession session;

    @Autowired
    private Gson g;

    @ResponseBody
    @RequestMapping("commentFrm")
    public String commentFrm(int parent_seq, String guestbook_comment_contents, GuestbookCommentDTO dto) { //String 형이야

        System.out.println(parent_seq+":"+guestbook_comment_contents);

        String Guestbook_comment_writer = (String) session.getAttribute("sessionID");

        dto.setGuestbook_comment_writer(Guestbook_comment_writer);
        dto.setParent_seq(parent_seq);
        dto.setGuestbook_comment_contents(guestbook_comment_contents);

        service.insert(dto);
        return "redirect:guestbookGo";
    }

    @RequestMapping ("guestbookGo")
    public String gogoGuestbook(Model model){

        List<GuestbookDTO> list = GuestbookService.select();
        List<GuestbookCommentDTO> list1 = service.select();
        model.addAttribute("dto", list);
        model.addAttribute("list1", list1);
        return "guestbook";
    }

}
