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

    public int insert(GuestbookDTO dto) {
        return GuestbookMapper.insert(dto);
    }

    public int delete(int Guestbook_Seq) {return GuestbookMapper.delete(Guestbook_Seq);}

    public int update(GuestbookDTO dto) {return GuestbookMapper.update(dto); }
}
