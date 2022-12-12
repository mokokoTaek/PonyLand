package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
public class AlbumDTO {

    private Integer Album_seq;
    private String Album_title;
    private String Album_contents;
    private String Album_oriname;
    private String Album_sysname;
    private Timestamp Album_sysdate;



}