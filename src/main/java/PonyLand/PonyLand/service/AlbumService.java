package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.AlbumDAO;
import PonyLand.PonyLand.dto.AlbumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

}