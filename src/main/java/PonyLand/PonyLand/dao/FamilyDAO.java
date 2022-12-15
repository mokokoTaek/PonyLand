package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Repository.Family.SpringDataJpaFamilyRepository;
import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class FamilyDAO {

    @Autowired
    private SpringDataJpaFamilyRepository sdjr;

    public void getFamily(String familyProposerId, String familyProposedId){
        FamilyDTO dto = new FamilyDTO();
        dto.setFamilyProposerId(familyProposerId);
        dto.setFamilyProposedId(familyProposedId);
        sdjr.save(dto);
    }

    public FamilyDTO areTheyFamily(String familyProposerId, String familyProposedId){
        return sdjr.findByFamilyProposerIdAndFamilyProposedId(familyProposerId,familyProposedId);
    }





}
