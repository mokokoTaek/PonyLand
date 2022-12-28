package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Mapper.GuestbookMapper;
import PonyLand.PonyLand.Mapper.MessageMapper;
import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.dto.MessageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageDAO {

    @Autowired
    PonyLand.PonyLand.Mapper.MessageMapper MessageMapper;
    @Autowired
    private SqlSession db;
    public int insert(MessageDTO dto) {return MessageMapper.insert(dto);
        }

    public List<MessageDTO> selectAll(String id){
        return MessageMapper.selectAll(id);
    }

    public MessageDTO selectBySeq(int seq) {
        return MessageMapper.selectBySeq(seq);
    }

    public List<MessageDTO> sentMailAll(String id) {
        return MessageMapper.sentMailAll(id);}

    public int delete(int seq){
        return MessageMapper.delete(seq);
    }
}

