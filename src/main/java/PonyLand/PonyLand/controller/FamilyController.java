package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/family/")
public class FamilyController {

    @Autowired
    private FamilyService service;

    @Autowired
    private HttpSession session;

    @RequestMapping("getFamily")
    @ResponseBody
    public String getFamily(String familyProposerId, String familyProposedId, String me, String other,Model model) throws IOException {
        System.out.println(familyProposerId);
        System.out.println(familyProposedId);
        System.out.println(me);
        System.out.println(other);
        return String.valueOf(service.getFamily(service.areTheyFamily(familyProposerId,familyProposedId),familyProposerId,familyProposedId));
    }

//    @RequestMapping("areTheyFamily")
//    public String areTheyFamily(String proposer, String proposed){
//        Boolean areTheyFamily = service.areTheyFamily(proposer,proposed);
//        return "redirect:/toMiniPage";
//    }
}
