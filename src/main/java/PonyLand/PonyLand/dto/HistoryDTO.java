package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HistoryDTO {
    private int history_seq;
    private String history_host;
    private String history_name_1;
    private String history_familyName_1;
    private String history_name_2;
    private String history_familyName_2;
    private String history_name_3;
    private String history_familyName_3;
}
