package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.AlbumDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    int update(MemberDTO dto);
    void imgupdate(MemberDTO dto);

    int duplCheck(String memberId);

    void message(MemberDTO dto);



}
