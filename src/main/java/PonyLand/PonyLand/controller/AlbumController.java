package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.AlbumCommentDTO;
import PonyLand.PonyLand.dto.AlbumDTO;
import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.service.AlbumCommentService;
import PonyLand.PonyLand.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Album/")
public class AlbumController {

    @Autowired
    private AlbumService service;
    @Autowired
    private AlbumCommentService albumCommentService;


    @Autowired
    private AlbumCommentService AlbumCommentService;






//    }

    @RequestMapping("write")
    public String write(Model model , String Album_host) {

//        model.addAttribute(session.getAttribute("sessionID").toString());
//        System.out.println(session);

        model.addAttribute("id",Album_host);
        return "albumwrite";
    }

    @RequestMapping("insert")
    public String insert(AlbumDTO dto) {
        try {
            service.insert(dto);
            System.out.println(dto.getAlbum_contents() + ":" + dto.getAlbum_title());

        } catch (Exception e) {
            return "error";
        }

        return "redirect:view";
    }

    @RequestMapping("view")
    public String SelectAll(Model model) {
        List<AlbumDTO> list = service.selectAll();


        model.addAttribute("dto", list);


        return "album";
    }


    @RequestMapping("delete")
    public String delete(int Album_seq) {
        service.delete(Album_seq);

        return "redirect:toAlbumPage";
    }

    @RequestMapping("update")
    public String update(String Album_title, String Album_contents, int Album_seq, Model model) {
        service.update(Album_title, Album_contents, Album_seq);
//       수정.
//        List<AlbumDTO> list= service.selectAll();
//        model.addAttribute("date",list);
        return "redirect:toAlbumPage";

    }

//사진첩으로 가는길 ,
    @RequestMapping("toAlbumPage")
    public String goGuestbook(Model model,String Album_host) {
        List<AlbumDTO> list = service.selectAll();
        model.addAttribute("dto", list);
//세션담아서 가줌.
        model.addAttribute("id",Album_host);





        return "album";
    }

    @RequestMapping("UpdateAlbum")
    public String UpdateAlbum(Model model) {
        List<AlbumDTO> list= service.selectAll();
        model.addAttribute("dto",list);
        return "albumupdate";
    }
}
