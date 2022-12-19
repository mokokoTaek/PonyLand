package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.AlbumDTO;
import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.dto.MessageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.bridge.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    int insert(MessageDTO dto);
    List<MessageDTO> selectAll(String id);

    MessageDTO selectBySeq(int seq);
}