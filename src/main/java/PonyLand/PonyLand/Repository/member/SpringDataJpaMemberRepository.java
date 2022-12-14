package PonyLand.PonyLand.Repository.member;

import PonyLand.PonyLand.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Member;

import javax.transaction.Transactional;

public interface SpringDataJpaMemberRepository extends JpaRepository<MemberDTO,Integer> {
    @Transactional
    Long countBy();

    @Transactional
    MemberDTO findByMemberIdAndMemberPw(String memberId, String memberPw);

    @Transactional
    MemberDTO findByMemberId(String memberId);

    @Transactional
    MemberDTO findByMemberSeq(int seq);

    @Query(value = "select member_id from (select member.*,row_number()over(order by member_seq desc)as rn from member) where rn=:rn", nativeQuery = true)
    String getIdByRowNum(@Param("rn") int rn);


}
