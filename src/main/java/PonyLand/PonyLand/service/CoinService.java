package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.CoinDAO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {
    @Autowired
    CoinDAO dao;

    public int selectByOne(String id) {
        System.out.println(id + "서비스");
        return dao.selectByOne(id);
    }

    public String setCoin(int coin, String id) {
        return dao.setCoin(coin, id);
    }


}
