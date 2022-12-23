package PonyLand.PonyLand.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private int no;
    private String send_nick;
    private String recv_nick;
    private String title;
    private Timestamp send_time;
    private String content;

}
