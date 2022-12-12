package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Guestbook/")
public class GuestbookController {

    @Autowired
    private GuestbookService service;


    @RequestMapping("insert")
    public String insert(GuestbookDTO dto) {
        try {
            service.insert(dto);
            System.out.println(dto.getGuestbook_contents());
        } catch (Exception e) {
            return "error";
        }
        return "redirect:guestbook.html";


    }
}
