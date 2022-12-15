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
       String id =  (String)session.getAttribute("sessionID");
        System.out.println(session.getAttribute("sessionID"));
        model.addAttribute("id", id);
        return "message";
    }

   public void insert(MessageDTO dto) {
       int result = service.insert(dto);
   }
}
