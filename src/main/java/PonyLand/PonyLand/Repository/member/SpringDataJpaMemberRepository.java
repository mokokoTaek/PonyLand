package PonyLand.PonyLand.Repository.member;

import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface SpringDataJpaMemberRepository extends JpaRepository<MemberDTO,Integer> {
    @Transactional
    Long countBy();

    @Transactional
    MemberDTO findByMember_seq(int seq);
}
