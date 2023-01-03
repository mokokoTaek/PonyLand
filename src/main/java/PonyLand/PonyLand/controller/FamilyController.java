package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/family/")
public class FamilyController {

    @Autowired
    private FamilyService service;

    @Autowired
    private HttpSession session;

    @RequestMapping("getFamily")
    @ResponseBody
    public String getFamily(String familyProposerId, String familyProposedId, String familyMe, String familyOther,Model model) throws IOException {
//        System.out.println(familyProposerId);
//        System.out.println(familyProposedId);
//                System.out.println(familyMe);
//        System.out.println(familyOther);

        return String.valueOf(service.getFamily(service.areTheyFamily(familyProposerId,familyProposedId),familyProposerId,familyProposedId,familyMe,familyOther));
    }

    @RequestMapping("checkNewFamily")
    public String checkNewFamily(Model model){
        List<FamilyDTO> list = service.checkNewFamily((String)session.getAttribute("sessionID"),0);
        List<String> imagelist = service.getProposerImage(list);


        model.addAttribute("list",list);
        model.addAttribute("imagelist",imagelist);

//        System.out.println(service.checkNewFamily((String)session.getAttribute("sessionID"),0).size());
        return "checkNewFamilyList";
    }

    @RequestMapping("agreeFamily")
    public String agreeFamily(int familySeq,Model model){
        FamilyDTO dto = service.agreeFamily(familySeq);
        dto.setFamilyStatus(1);
        service.save(dto);
        List<FamilyDTO> list = service.checkNewFamily((String)session.getAttribute("sessionID"),0);
        List<String> imagelist = service.getProposerImage(list);

        model.addAttribute("list",list);
        model.addAttribute("imagelist",imagelist);

        return "checkNewFamilyList";
    }

    @RequestMapping("refuseFamily")
    public String refuseFamily(int familySeq,Model model){
        System.out.println("컨트롤러는 왔음");
        service.deleteByFamilySeq(familySeq);
        System.out.println("서비스 동작 완료");

        List<FamilyDTO> list = service.checkNewFamily((String)session.getAttribute("sessionID"),0);
        List<String> imagelist = service.getProposerImage(list);

        model.addAttribute("list",list);
        model.addAttribute("imagelist",imagelist);
        return "checkNewFamilyList";
    }

    @RequestMapping("deleteFamily")
    public String deleteFamily(int targetSeq){
        System.out.println(targetSeq);
        service.deleteByFamilySeq(targetSeq);
        return "redirect:/family/familyListOpen";
    }

    @RequestMapping("familyListOpen")
    public String familyListOpen(Model model){
        String id = (String)session.getAttribute("sessionID");

        List<FamilyDTO> list1 = service.getFamilyListByProposerId(id);
        List<FamilyDTO> list2 = service.getFamilyListByProposedId(id);

        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        return "familyListOpen";
    }


//    @RequestMapping("areTheyFamily")
//    public String areTheyFamily(String proposer, String proposed){
//        Boolean areTheyFamily = service.areTheyFamily(proposer,proposed);
//        return "redirect:/toMiniPage";
//    }
}
