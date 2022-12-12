package PonyLand.PonyLand.Repository;

import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<MemberDTO,Integer> {
    Long countBy();
}
