package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Setter
@Getter
@AllArgsConstructor
public class GuestbookDTO {

    private Integer Guestbook_seq;
    private String Guestbook_writer;
    private String Guestbook_contents;
    private Timestamp Guestbook_write_date;

}
