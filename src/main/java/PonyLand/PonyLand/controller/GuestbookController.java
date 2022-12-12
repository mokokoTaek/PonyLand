package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Guestbook/")
public class GuestbookController {

    @Autowired
    private GuestbookService service;


    @RequestMapping("/Write")
    public String write() { return "guestbookWrite"; }





}
