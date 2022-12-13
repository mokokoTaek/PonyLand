package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.FamilyDAO;
import PonyLand.PonyLand.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class FamilyService {

    @Autowired
    private FamilyDAO dao;

    @RequestMapping("/getFamily")
    public void getFamily(FamilyDTO dto){
        dao.getFamily(dto);
    }

    @RequestMapping
    public void areTheyFamily(String familyProposerId,String familyProposedId){
        FamilyDTO dto1 = dao.areTheyFamily(familyProposerId,familyProposedId);
        FamilyDTO dto2 = dao.areTheyFamily(familyProposedId,familyProposerId);
        System.out.println(dto1.getFamilyProposerId());
        System.out.println(dto2.getFamilyProposedId());
        if(((dto1!=null) && dto1.getFamilyProposerId().equals(dto2.getFamilyProposedId()))){
            System.out.println("두 회원은 일촌관계입니다!");
        }
        else{
            System.out.println("두 회원은 일촌관계가 아닙니다!");
        }
    }
}
