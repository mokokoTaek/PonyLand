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
public class AlbumDTO {

    private int Album_seq;
    private String Album_title;
    private String Album_contents;
    private String Album_oriname;
    private String Album_sysname;
    private Timestamp Album_write_date;
    private String Album_writer;
    private String Album_host;


}