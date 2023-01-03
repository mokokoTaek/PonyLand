package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Repository.Family.SpringDataJpaFamilyRepository;
import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public class FamilyDAO {

    @Autowired
    private SpringDataJpaFamilyRepository sdjr;


    public FamilyDTO getInfo(String host, String guest) {

        FamilyDTO dto = sdjr.findByFamilyProposerIdAndFamilyProposedId(host, guest);
        FamilyDTO dto2 = sdjr.findByFamilyProposerIdAndFamilyProposedId(guest, host);

        if (dto == null && dto2 != null) {
            return dto2;
        } else if(dto==null && dto2==null){
            return dto;
        }
        return dto;
    }


    public void getFamily(String familyProposerId, String familyProposedId,String familyMe, String familyOther,int familyStatus,String familyProposerName, String familyProposedName){
        FamilyDTO dto = new FamilyDTO();
        dto.setFamilyProposerId(familyProposerId);
        dto.setFamilyProposedId(familyProposedId);
        dto.setFamilyMe(familyMe);
        dto.setFamilyOther(familyOther);
        dto.setFamilyProposerName(familyProposerName);
        dto.setFamilyProposedName(familyProposedName);
        sdjr.save(dto);
    }

    public FamilyDTO areTheyFamily(String familyProposerId, String familyProposedId){
        return sdjr.findByFamilyProposerIdAndFamilyProposedId(familyProposerId,familyProposedId);
    }

    public List<FamilyDTO> checkNewFamily(String familyProposedId, int familyStatus){
        return sdjr.findAllByFamilyProposedIdAndFamilyStatus(familyProposedId,familyStatus);
    }

    public FamilyDTO findByFamilySeq(int familySeq){
        return sdjr.findByFamilySeq(familySeq);
    }

    public void deleteByFamilySeq(int familySeq){
        sdjr.deleteByFamilySeq(familySeq);
    }

    public List<FamilyDTO> getFamilyListByProposerId(String id){
        return sdjr.findAllByFamilyStatusAndFamilyProposerId(1,id);
    }

    public List<FamilyDTO> getFamilyListByProposedId(String id){
        return sdjr.findAllByFamilyStatusAndFamilyProposedId(1,id);
    }

    public void save(FamilyDTO dto){
        sdjr.save(dto);
    }
}
