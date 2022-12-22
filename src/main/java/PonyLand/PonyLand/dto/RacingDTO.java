package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //해당 객체 내에 있는 모든 변수들을 인수로 받는 생성자를 만들어내는 어노테이션
@NoArgsConstructor
public class RacingDTO {
    private String racing_id;
    private String racing_horse_seq;
    private int racing_coin;
    private int bettingCoin;

}
