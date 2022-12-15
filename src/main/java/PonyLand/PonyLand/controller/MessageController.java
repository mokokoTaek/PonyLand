package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.dto.MessageDTO;
import PonyLand.PonyLand.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/message/")
public class MessageController {
    @Autowired
    private MessageService service;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletResponse response;

    @GetMapping("message")
    public String message(MemberDTO dto, Model model){
       String id = (String)session.getAttribute("sessionID");
        List<MessageDTO> list = service.selectAll();
        System.out.println(session.getAttribute("sessionID"));
        model.addAttribute("id", id);
        model.addAttribute("list",list);
        return "message";
    }
    @GetMapping("write")
   public String write(MessageDTO dto, Model model) {
        String id = (String)session.getAttribute("sessionID");
        System.out.println(session.getAttribute("sessionID"));
        model.addAttribute("id", id);
//       int result = service.insert(dto);
        return "messageinput";
   }

    @RequestMapping("insert" )
    public void insert(MessageDTO dto) throws Exception {
      int result = service.insert(dto);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('전송 되었습니다.'); history.go(-1);</script>");
        out.flush();
        response.flushBuffer();
        out.close();
    }
}
