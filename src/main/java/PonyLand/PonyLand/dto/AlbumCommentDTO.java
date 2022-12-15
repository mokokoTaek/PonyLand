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
public class AlbumCommentDTO {

    private int Album_Comment_seq;
    private String Album_Comment_writer;
    private String Album_Comment_contents;
    private Timestamp Album_Comment_write_date;
    private Integer Album_Comment_parent_seq;


}
