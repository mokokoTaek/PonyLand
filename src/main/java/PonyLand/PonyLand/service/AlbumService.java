package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.AlbumDAO;
import PonyLand.PonyLand.dto.AlbumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumDAO dao;


    public int insert(AlbumDTO dto ) {
        return dao.insert(dto);
    }

    public List<AlbumDTO> selectAll() {
        return dao.selectAll();
    }

    public int delete(int Album_seq) { return dao.delete(Album_seq); }

    public int update(String Album_title, String Album_contents ,int Album_seq) {
        return dao.update(Album_title,Album_contents,Album_seq);
    }

    public int count(String Album_writer) {  //게시글 총 갯수
        return dao.count(Album_writer);
    }
    public List<AlbumDTO> select() {
        return dao.select();
    }

//    public String selectHost(int album_seq){
//        System.out.println("권준구 : 서비스 앨범 씨컨스 값 : "+album_seq);
//        return dao.selectHost(album_seq);}
//    public List<AlbumDTO> replycount() {
//        return dao.replycount();
//    }

    public int selectByDate(String Album_writer) { // 사진첩 하루안에 올린 글 갯수
        return dao.selectByDate(Album_writer);
    }


}
