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
    public List<AlbumCommentDTO> selectComment(int Album_Comment_parent_seq) {
        return dao.selectComment( Album_Comment_parent_seq);
    }
}
