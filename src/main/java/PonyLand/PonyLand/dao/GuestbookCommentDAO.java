package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestbookCommentDAO {

    @Autowired
    PonyLand.PonyLand.Mapper.GuestbookCommentMapper GuestbookCommentMapper;

    public int insert(GuestbookCommentDTO dto) {return GuestbookCommentMapper.insert(dto);}

    public List<GuestbookCommentDTO> select(int parent_seq) {return GuestbookCommentMapper.select(parent_seq);}


    //public int delete(int Guestbook_comment_Seq) {return GuestbookCommentMapper.delete(Guestbook_comment_Seq);}
}
