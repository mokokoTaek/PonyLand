package PonyLand.PonyLand.Mapper;

import PonyLand.PonyLand.dto.RacingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GameMapper {

    //코인 배팅 금약 insert문
    void insertCoin(Map<String, Object> map);

    //배팅 후 racing 쿼리 날리는 문
    void deleteBet(String id);

    //배팅 성공시 member table에 업데이트문
    void updateWin(RacingDTO dto);

    //배팅 실패 시 memeber tabe에 돈 빼는 업데이트 문
   /* void updateLose(RacingDTO dto);*/

    RacingDTO selectBet(String id);


    //게임 시작 버튼 클릭시 member_Coin에서 배팅금액 먼저 뺴는 코드
    void updateCoin(Map<String, Object> map);
}
