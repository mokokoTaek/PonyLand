package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int update(MemberDTO dto);
    void imgupdate(MemberDTO dto);

    int duplCheck(String memberId);

    void message(MemberDTO dto);

}
