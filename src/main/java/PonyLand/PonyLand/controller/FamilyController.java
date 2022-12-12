package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/family/")
public class FamilyController {

    @Autowired
    FamilyService service;

    @RequestMapping("getFamily")
    public String getFamily(FamilyDTO dto){

        service.getFamily(dto);

        return "";
    }
}
