package PonyLand.PonyLand.controller;
import java.util.Collections;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.dto.MessageDTO;
import PonyLand.PonyLand.service.MessageService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //보낸 쪽지 & 받은 쪽지 뿌리기 기능
    @GetMapping("message")
    public String message(Model model){
       String id = (String)session.getAttribute("sessionID");
        model.addAttribute("id", id);
        List<MessageDTO> list = service.selectAll(id);
        List<MessageDTO> list2 = service.sentMailAll(id);
        Collections.reverse(list);
        Collections.reverse(list2);
        model.addAttribute("list",list);
        model.addAttribute("list2", list2);
        return "message";
    }
    @GetMapping("write")
   public String write(Model model) {
        String id = (String)session.getAttribute("sessionID");
        System.out.println(session.getAttribute("sessionID"));
        model.addAttribute("id", id);
//       int result = service.insert(dto);
        return "messageinput";
   }

    //쪽지 보내기
    @RequestMapping("insert" )
    public void insert(MessageDTO dto) throws Exception {
        service.insert(dto);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('전송 되었습니다.'); window.opener.location.reload(); window.close();</script>");
        out.flush();
        response.flushBuffer();
        out.close();
    }

    //쪽지 디테일에 정보 뿌리기
    @ResponseBody
    @RequestMapping("detail")
    public String detail(String no) {
        System.out.println(no);
        MessageDTO dto = service.selectBySeq(Integer.parseInt(no));
        Gson g = new Gson();
        return g.toJson(dto);
    }

    @RequestMapping("delete" )
    public void delete(int seq) throws Exception{
        System.out.println(seq);
        service.delete(seq);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('삭제 되었습니다.'); location.reload(); </script>");
        out.flush();
        response.flushBuffer();
        out.close();
    }
}
