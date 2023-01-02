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
    private String history_id;
    private String history_name;
    private String history_familyName;
}
