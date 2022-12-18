package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestbookCommentMapper {

    int insert(GuestbookCommentDTO dto);


    int delete(int guestbook_Comment_Seq);

    List<GuestbookCommentDTO> select();
}
