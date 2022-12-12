package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.GuestbookDAO;
import PonyLand.PonyLand.dto.GuestbookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestbookService {

    @Autowired
    GuestbookDAO dao;


    public int insert(GuestbookDTO dto) { return dao.insert(dto);}


    public int delect(int Guestbook_Seq) {return dao.delete(Guestbook_Seq); }
}
