package PonyLand.PonyLand.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GameMapper {

    //코인 배탱 성공시 업데이트 문
    void updateCoin(Map<String, Object> map);
}
