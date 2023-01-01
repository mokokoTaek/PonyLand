package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Mapper.HistoryMapper;
import PonyLand.PonyLand.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryDAO {

    @Autowired
    private HistoryMapper historyMapper;

    public List<HistoryDTO> selectId(){
        return historyMapper.selectId();
    }

    public int historyInsert (String history_host, String history_id, String history_name){
        return historyMapper.historyInsert(history_host,history_id,history_name);
    }
}
