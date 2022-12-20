package PonyLand.PonyLand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MiniGame/")
public class MiniGameController {

    @Autowired
    private HttpSession session;

}
