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

    public int insert(GuestbookCommentDTO dto) {
        return dao.insert(dto);
    }

    public List<GuestbookCommentDTO> select() {return dao.select();}
}
