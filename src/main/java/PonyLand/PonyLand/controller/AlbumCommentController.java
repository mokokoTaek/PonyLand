package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.AlbumCommentDTO;
import PonyLand.PonyLand.service.AlbumCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Comment/")
public class AlbumCommentController {

    @Autowired
    private AlbumCommentService service;

    @RequestMapping("write")
    public String write(AlbumCommentDTO dto) {
        service.insert(dto);
        return "album";
    }


}
