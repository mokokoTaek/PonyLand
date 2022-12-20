package PonyLand.PonyLand.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GameMapper {

    void updateCoin(Map<String, Object> map);
}
