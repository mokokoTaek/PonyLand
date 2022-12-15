package PonyLand.PonyLand.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class MessageDTO {

    private Integer no;
    private String send_nick;
    private String recv_nick;
    private Timestamp send_time;
    private String content;
}
