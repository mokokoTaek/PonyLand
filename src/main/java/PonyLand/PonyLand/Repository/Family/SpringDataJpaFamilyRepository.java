package PonyLand.PonyLand.Repository.Family;

import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface SpringDataJpaFamilyRepository extends JpaRepository<FamilyDTO,Integer> {

    @Transactional
    FamilyDTO findByFamilyProposerIdAndFamilyProposedId(String FamilyProposerId, String FamilyProposedId);

    @Transactional
    FamilyDTO findByFamilyProposedIdAndFamilyProposerId(String FamilyProposerId, String FamilyProposedId);
}
