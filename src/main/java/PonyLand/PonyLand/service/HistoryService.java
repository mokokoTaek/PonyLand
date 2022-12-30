package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.HistoryDAO;
import PonyLand.PonyLand.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryDAO historyDAO;
//    public HistoryDTO selectId(){
//        return historyDAO.selectId();
//    }
}
