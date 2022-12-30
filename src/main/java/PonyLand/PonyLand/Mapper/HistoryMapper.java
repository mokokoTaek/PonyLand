package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.HistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {
    HistoryDTO selectId();
}
