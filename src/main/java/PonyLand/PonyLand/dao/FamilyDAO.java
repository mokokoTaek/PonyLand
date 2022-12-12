package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Repository.Family.SpringDataJpaFamilyRepository;
import PonyLand.PonyLand.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class FamilyDAO {

    @Autowired
    private SpringDataJpaFamilyRepository sdjr;

    public void getFamily(FamilyDTO dto){
        sdjr.save(dto);
    }

    public Long areTheyFamily1(String familyProposerId, String familyProposedId){
        return sdjr.countByFamily_proposer_idAndFamily_proposed_id(familyProposerId,familyProposedId);


    }
    public Long areTheyFamily2(String familyProposerId, String familyProposedId) {
        return sdjr.countByFamily_proposer_idAndFamily_proposed_id(familyProposedId, familyProposerId);
    }
}
