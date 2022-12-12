package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.GuestbookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestbookMapper {

    int insert(GuestbookDTO dto);

    int delete (int Guestbook_seq);

    int update(GuestbookDTO dto);

    List<GuestbookDTO> selectAll();

}
