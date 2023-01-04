package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GuestbookDTO {

    private Integer guestbook_seq;
    private String guestbook_writer;
    private String guestbook_contents;
    private Timestamp guestbook_write_date;
    private String guestbook_host;
    private String guestbook_sysname;

}
