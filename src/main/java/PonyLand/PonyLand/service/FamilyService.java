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
        Long check1= dao.areTheyFamily1(familyProposerId,familyProposedId);
        Long check2= dao.areTheyFamily2(familyProposerId,familyProposedId);

        if(check1>0 && (check1 == check2)){
            System.out.println("두 회원은 일촌관계입니다!");
        }
        else{
            System.out.println("두 회원은 일촌관계가 아닙니다!");
        }
    }
}
