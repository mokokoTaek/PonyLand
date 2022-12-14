package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.AlbumCommentDTO;
import PonyLand.PonyLand.service.AlbumCommentService;
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

    @ResponseBody
    @RequestMapping("write")
    public String write(AlbumCommentDTO dto) {
        service.insert(dto);
        return "album";
    }
//    @RequestMapping("select")
//    public String select(Model model, int Album_Comment_parent_seq) {
//
//        List<AlbumCommentDTO> list1 = service.selectComment(Album_Comment_parent_seq);
//        model.addAttribute("dto1",list1);
//        return "album";
//    }





}
