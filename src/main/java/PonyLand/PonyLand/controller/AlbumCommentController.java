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
    @RequestMapping("write")
    public String write(String Album_Comment_parent_seq,String Album_Comment_contents) {
        AlbumCommentDTO dto = new AlbumCommentDTO();
        dto.setAlbum_Comment_parent_seq(Integer.parseInt(Album_Comment_parent_seq));
        System.out.println(Album_Comment_parent_seq);

        dto.setAlbum_Comment_contents(Album_Comment_contents);
        System.out.println(Album_Comment_contents);

        service.insert(dto);

        List<AlbumCommentDTO> list  = service.selectComment(Integer.parseInt(Album_Comment_parent_seq));

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
