package PonyLand.PonyLand.Repository;

import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<MemberDTO,Integer> {
    Long countBy();

    MemberDTO findByMemberIdAndMemberPw(String memberId, String memberPw);

}
