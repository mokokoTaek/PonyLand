package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.AlbumCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlbumCommentMapper {

    int insert(AlbumCommentDTO dto);

    List<AlbumCommentDTO> selectComment(int Album_Comment_parent_seq);
}
