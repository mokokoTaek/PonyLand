package PonyLand.PonyLand.Mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoinMapper {
    int selectByOne(String id);
    String setCoin(int coin, String id);
}
