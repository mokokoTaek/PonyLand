package PonyLand.PonyLand.Repository.Family;

import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SpringDataJpaFamilyRepository extends JpaRepository<FamilyDTO,Integer> {

    @Transactional
    FamilyDTO findByFamilyProposerIdAndFamilyProposedId(String FamilyProposerId, String FamilyProposedId);

    @Transactional
    List<FamilyDTO> findAllByFamilyProposedIdAndFamilyStatus(String familyProposedId,int familyStatus);

    @Transactional
    FamilyDTO findByFamilySeq(int familySeq);

    @Transactional
    void deleteByFamilySeq(int familySeq);

    @Transactional
    List<FamilyDTO> findAllByFamilyStatusAndFamilyProposerId(int familyStatus, String familyProposerId);

    @Transactional
    List<FamilyDTO> findAllByFamilyStatusAndFamilyProposedId(int familyStatus, String familyProposedId);
}
