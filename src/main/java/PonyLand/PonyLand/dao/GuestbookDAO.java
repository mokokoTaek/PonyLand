package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Mapper.GuestbookMapper;
import PonyLand.PonyLand.dto.GuestbookDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestbookDAO {

    @Autowired
    GuestbookMapper GuestbookMapper;


    @Autowired
    private SqlSession db;


    public int insert(GuestbookDTO dto) {
        return db.insert("Member.insert", dto);
    }

}
