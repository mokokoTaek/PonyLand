package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.HistoryDAO;
import PonyLand.PonyLand.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryDAO historyDAO;
    public List<HistoryDTO> selectId(){
        return historyDAO.selectId();
    }

    public int historyInsert(String history_host, String history_id, String history_name){
        return  historyDAO.historyInsert(history_host,history_id,history_name);
    }
}
