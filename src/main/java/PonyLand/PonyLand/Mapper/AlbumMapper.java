package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.AlbumDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface AlbumMapper {
    int insert(AlbumDTO dto);

    List<AlbumDTO> selectAll();

    int delete(int Album_seq);

    int update(String Album_title, String Album_contents, int Album_seq);

    int count(String Album_writer);   //게시글 총 갯수

//    String selectHost(int album_seq);
    List<AlbumDTO> select();

//    List<AlbumDTO> replycount();
    int selectByDate(String Album_writer); // 사진첩 하루안에 올린 글 갯수






}