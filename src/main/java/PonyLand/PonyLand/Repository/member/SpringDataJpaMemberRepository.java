package PonyLand.PonyLand.Repository.member;

import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;

import javax.transaction.Transactional;

public interface SpringDataJpaMemberRepository extends JpaRepository<MemberDTO,Integer> {
    @Transactional
    Long countBy();

    @Transactional
    MemberDTO findByMemberIdAndMemberPw(String memberId, String memberPw);

    @Transactional
    MemberDTO findByMemberSeq(int seq);

}
