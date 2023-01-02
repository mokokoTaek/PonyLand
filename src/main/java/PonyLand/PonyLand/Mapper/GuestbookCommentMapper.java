package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestbookCommentMapper {

    GuestbookCommentDTO selectComment(int questbook_comment_seq);

    int insert(GuestbookCommentDTO dto);

    int delete(int guestbook_comment_seq);

    List<GuestbookCommentDTO> select();
}
