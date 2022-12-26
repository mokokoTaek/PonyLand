package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Mapper.AlbumMapper;
import PonyLand.PonyLand.dto.AlbumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class AlbumDAO {

    @Autowired
    AlbumMapper albumMapper;

    public int insert(AlbumDTO dto ) {
        System.out.println(dto.getAlbum_contents()+":"+dto.getAlbum_title());
        return albumMapper.insert(dto);
    }

    public List<AlbumDTO> selectAll(){
        return albumMapper.selectAll();
    }
    public int delete(int Album_seq) {
        return albumMapper.delete(Album_seq);
    }
    public int update(String Album_title, String Album_contents,int Album_seq ) {
        return albumMapper.update(Album_title,Album_contents ,Album_seq);
    }
    public int count(String Album_writer) { //게시글 총 갯수
        return albumMapper.count(Album_writer);
    }
    public List<AlbumDTO> select(){
        return albumMapper.select();
    }
    public int selectByDate(String Album_writer) { // 사진첩 하루안에 올린 글 갯수
        return albumMapper.selectByDate(Album_writer);
    }

//    public  String selectHost(int album_seq) {
//        return albumMapper.selectHost(album_seq);
//    }
//    public List<AlbumDTO> replycount() {
//        return albumMapper.replycount();
//    }




}
