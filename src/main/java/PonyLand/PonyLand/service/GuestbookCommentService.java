package PonyLand.PonyLand.service;


import PonyLand.PonyLand.dao.GuestbookCommentDAO;
import PonyLand.PonyLand.dto.GuestbookCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestbookCommentService {

    @Autowired
    GuestbookCommentDAO dao;

    public GuestbookCommentDTO selectComment(int questbook_comment_seq){return dao.selectComment(questbook_comment_seq);}

    public int insert(GuestbookCommentDTO dto) {return dao.insert(dto);}

    public int delete(int guestbook_comment_seq) {
        return dao.delete(guestbook_comment_seq);
    }

    public List<GuestbookCommentDTO> select() {return dao.select();}
}
