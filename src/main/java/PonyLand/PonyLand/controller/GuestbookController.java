package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.GuestbookCommentService;
import PonyLand.PonyLand.service.GuestbookService;
import PonyLand.PonyLand.service.MemberService;
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
    private HttpSession session;

    @Autowired
    private GuestbookService GuestbookService;

    @Autowired
    private GuestbookCommentService GuestbookCommentService;

    @Autowired
    private MemberService memberService;



    @GetMapping("insert")
    public String insert(GuestbookDTO dto) throws Exception {
        String guestbook_writer = (String) session.getAttribute("sessionID");
        System.out.println(dto.getGuestbook_sysname());
        MemberDTO dto1 = memberService.findById((String)session.getAttribute("sessionID"));

        dto.setGuestbook_sysname(dto1.getMember_sysname());
        dto.setGuestbook_writer(guestbook_writer);
        GuestbookService.insert(dto);

        return "redirect:/Guestbook/goGuestbook?&guestbook_host="+dto.getGuestbook_host();
    }

    @RequestMapping("delete")
    public String delete(int Guestbook_seq, String guestbook_host) {
        GuestbookService.delect(Guestbook_seq);
        GuestbookDTO dto = new GuestbookDTO();
        dto.setGuestbook_host(guestbook_host);
        return "redirect:/Guestbook/goGuestbook?&guestbook_host="+dto.getGuestbook_host();
    }

    @RequestMapping("update")
    public String update(GuestbookDTO dto) {
        GuestbookService.update(dto);
        return "guestbook";
    }

    //미니홈피에서 방명록으로 가는 코트
    @RequestMapping("goGuestbook")
    public String goGuestbook(String guestbook_host, Model model) {

        MemberDTO dto = memberService.findById(guestbook_host);
        List<GuestbookDTO> list = GuestbookService.select();
        List<GuestbookCommentDTO> list1 = GuestbookCommentService.select();
        System.out.println(list1);

        model.addAttribute("id", guestbook_host);
        model.addAttribute("sessionID",session.getAttribute("sessionID"));
        model.addAttribute("dto", list);
        model.addAttribute("list1", list1);
        model.addAttribute("list2",dto);

        return "guestbook";
    }


    //방명록에서 글작성으로 가는 코드
    @RequestMapping("gowrite")
    public String gowrite(String guestbook_host, Model model) {
        MemberDTO dto = memberService.findById(guestbook_host);
        model.addAttribute("list",dto);
        model.addAttribute("id", guestbook_host);
        return "guesbookwrite";
    }
}
