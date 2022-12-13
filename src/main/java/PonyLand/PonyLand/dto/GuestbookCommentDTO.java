package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor //해당 객체 내에 있는 모든 변수들을 인수로 받는 생성자를 만들어내는 어노테이션
public class GuestbookCommentDTO {

    private Integer gusetbook_comment_seq;
    private String guestbook_comment_writer;
    private String guestbook_comment_contents;
    private Timestamp guestbook_comment_write_date;
    private Integer parent_seq;

}
