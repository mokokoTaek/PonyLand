package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Mapper.AlbumCommentMapper;
import PonyLand.PonyLand.dto.AlbumCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumCommentDAO {

    @Autowired
    AlbumCommentMapper AlbumCommentmapper;

    public int insert(AlbumCommentDTO dto) {
        return AlbumCommentmapper.insert(dto);
    }

    public List<AlbumCommentDTO> selectComment(){

        return AlbumCommentmapper.selectComment();
    }
}