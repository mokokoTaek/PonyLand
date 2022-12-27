package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.AlbumCommentDAO;
import PonyLand.PonyLand.dto.AlbumCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumCommentService {
    @Autowired
    private AlbumCommentDAO dao;

    public int insert(AlbumCommentDTO dto) {
        return dao.insert(dto);
    }
    public List<AlbumCommentDTO> selectComment() {
        return dao.selectComment();
    }
    public int delete(int Album_Comment_seq) {
        return dao.delete(Album_Comment_seq);
    }
//    public AlbumCommentDTO selectParent(int Album_Comment_seq) {
//        return dao.selectParent(Album_Comment_seq);
//    }
}
