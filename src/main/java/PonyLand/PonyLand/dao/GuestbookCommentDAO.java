package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestbookCommentDAO {

    @Autowired
    PonyLand.PonyLand.Mapper.GuestbookCommentMapper GuestbookCommentMapper;

    public GuestbookCommentDTO selectComment(int questbook_comment_seq){return  GuestbookCommentMapper.selectComment(questbook_comment_seq);}

    public int insert(GuestbookCommentDTO dto) {return GuestbookCommentMapper.insert(dto);}

    public int delete(int guestbook_comment_seq) {
        System.out.println("dao : "+guestbook_comment_seq);
        return GuestbookCommentMapper.delete(guestbook_comment_seq);
    }

    public List<GuestbookCommentDTO> select() {return GuestbookCommentMapper.select();}

}
