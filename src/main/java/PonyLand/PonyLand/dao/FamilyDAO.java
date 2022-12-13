package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Repository.Family.SpringDataJpaFamilyRepository;
import PonyLand.PonyLand.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class FamilyDAO {

    @Autowired
    private SpringDataJpaFamilyRepository sdjr;

    public void getFamily(FamilyDTO dto){
        sdjr.save(dto);
    }

    public FamilyDTO areTheyFamily(String familyProposerId, String familyProposedId){
        return sdjr.findByFamilyProposerIdAndFamilyProposedId(familyProposerId,familyProposedId);
    }



}
