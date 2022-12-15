package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.MessageDAO;
import PonyLand.PonyLand.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {

    @Autowired
    MessageDAO dao;

    @Transactional
    public int insert(MessageDTO dto) {
        dao.insert(dto); // 게시판 글 쓰기 예제
        return 0;
    }


}
