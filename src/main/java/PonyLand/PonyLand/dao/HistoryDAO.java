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

//    public HistoryDTO selectId(){
//        return historyMapper.selectId();
//    }
}
