package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.dto.MessageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAO {
    @Autowired
    private SqlSession db;
    public int insert(MessageDTO dto) {
        db.insert("Message.insert", dto); // message-mapper의 이름옆에 . 을 찍고 insert 기능을 사용
        System.out.println(dto.getNo());
        return dto.getNo();
    }
}
