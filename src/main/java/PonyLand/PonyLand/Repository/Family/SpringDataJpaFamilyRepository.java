package PonyLand.PonyLand.Repository.Family;

import PonyLand.PonyLand.dto.FamilyDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaFamilyRepository extends JpaRepository<FamilyDTO,Integer> {
    Long countByFamily_proposer_idAndFamily_proposed_id(String familyProposerId, String familyProposedId);

}
