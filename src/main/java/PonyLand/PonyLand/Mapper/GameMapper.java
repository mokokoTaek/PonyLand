package PonyLand.PonyLand.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GameMapper {

    int update(Map<String, Object> map);
}
