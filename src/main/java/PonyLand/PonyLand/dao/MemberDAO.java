package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Repository.member.SpringDataJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private SpringDataJpaMemberRepository sdjr;

    public Long countMember(){
        return sdjr.countBy();
    }

    public String getIdBySeq(int seq){
        return sdjr.findByMember_seq(seq).getMember_id();
    }
}
