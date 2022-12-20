package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Mapper.MemberMapper;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.Repository.member.SpringDataJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
public class MemberDAO {


    @Autowired
    private SpringDataJpaMemberRepository sdjr;

    @Autowired
    MemberMapper MemberMapper;

    public Long countMember(){
        return sdjr.countBy();
    }

    public void insert(MemberDTO dto){
        sdjr.save(dto);
    }

    public MemberDTO login(String member_id, String member_pw){
        return sdjr.findByMemberIdAndMemberPw(member_id, member_pw);
    }
    public MemberDTO loginForKakao(String member_id){
        return sdjr.findByMemberId(member_id);
    }



    public String getIdByRowNum(int rn){
        return sdjr.getIdByRowNum(rn);
    }

    public MemberDTO findById(String id){return sdjr.findByMemberId(id);}

    public void addView(String id){
        sdjr.addView(id);
    }

    public int update(MemberDTO dto) {
        return MemberMapper.update(dto);
    }

    public String imgupdate(MemberDTO dto) {
        return MemberMapper.imgupdate(dto);
    }

}
