package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

@Controller
@RequestMapping("/Guestbook/")
public class GuestbookController {

    @Autowired
    private GuestbookService service;


    @RequestMapping("insert")
    public String insert(GuestbookDTO dto) throws Exception {
        service.insert(dto);
        System.out.println(dto.getGuestbook_contents());
        return "guestbook";
    }

    @RequestMapping("delete")
    public String delete(int Guestbook_seq){
        service.delect(Guestbook_seq);

        return "guestbook";
    }

    @RequestMapping("update")
    public String update(GuestbookDTO dto){
        service.update(dto);
        return "guestbook";
    }




}
