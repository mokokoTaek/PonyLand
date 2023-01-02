package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.GuestbookDTO;
import PonyLand.PonyLand.dto.HistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {
    List<HistoryDTO> selectId();

    int historyInsert(String history_host, String history_id, String history_name);
}
