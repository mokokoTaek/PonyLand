package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.AlbumDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlbumMapper {
    int insert(AlbumDTO dto);

    List<AlbumDTO> selectAll();

    int delete(int Album_seq);

    int update(String Album_title, String Album_contents, int Album_seq);

    int count();   //게시글 총 갯수

    List<AlbumDTO> select();

//    List<AlbumDTO> replycount();


}