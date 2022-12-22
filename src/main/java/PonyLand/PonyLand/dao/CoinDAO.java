package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CoinDAO {
    @Autowired
    PonyLand.PonyLand.Mapper.CoinMapper CoinMapper;


    public int selectByOne(String id) {
        System.out.println(id + "디에오");
        return CoinMapper.selectByOne(id);
    }

        public String setCoin(int coin, String id) {
        return CoinMapper.setCoin(coin, id);
        }

}
