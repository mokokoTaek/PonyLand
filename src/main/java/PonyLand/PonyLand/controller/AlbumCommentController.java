package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.AlbumCommentDTO;
import PonyLand.PonyLand.service.AlbumCommentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Comment/")
public class AlbumCommentController {

    @Autowired
    private AlbumCommentService service;
    @Autowired
    private Gson g;

    @ResponseBody
    @RequestMapping("writer")
    public String write(String Album_seq,String Album_Comment_contents) {
        System.out.println("1번 : " + Album_seq + " : " + Album_Comment_contents);
        AlbumCommentDTO dto = new AlbumCommentDTO();
        dto.setAlbum_Comment_parent_seq(Integer.parseInt(Album_seq));
        dto.setAlbum_Comment_contents(Album_Comment_contents);
        System.out.println("2번 : " + dto.getAlbum_Comment_parent_seq());
        System.out.println("3번 : " + dto.getAlbum_Comment_contents());
        System.out.println("a");
        service.insert(dto);
        System.out.println("b");
        List<AlbumCommentDTO> list  = service.selectComment(Integer.parseInt(Album_seq));
        System.out.println("4번 : " + list);

        String s = g.toJson(list);
        return s;
    }






//    @RequestMapping("select")
//    public String select(Model model, int Album_Comment_parent_seq) {
//
//        List<AlbumCommentDTO> list1 = service.selectComment(Album_Comment_parent_seq);
//        model.addAttribute("dto1",list1);
//        return "album";
//    }





}
