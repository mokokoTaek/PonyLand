package PonyLand.PonyLand.dto;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@DynamicInsert
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
@SequenceGenerator(
        name = "member_seq_generator"
        , sequenceName = "member_seq"
        , initialValue = 1
        , allocationSize = 1
)
public class MemberDTO {

        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE
                , generator = "member_seq_generator"
        )
        @Column(name = "member_seq")
        private int memberSeq;


//    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ex_seq")
//    @SequenceGenerator(sequenceName = "example_seq",allocationSize = 1, name = "ex_seq")


        @Column(name = "member_id")
        private String memberId;

        @Column(name = "member_name")
        private String member_name;

        @Column(name = "member_phone")
        private String member_phone;

        @Column(name = "member_email")
        private String member_email;

        @Column(name = "member_coin")
        private int member_coin;

        @Column(name = "member_pw")
        private String memberPw;

        @Column(name="member_login_type")
        private String memberLoginType;

        @Column(name="member_homepage_view_count")
        private int memberHomepageViewCount;

        @Column(name="member_oriname")
        private String member_oriname;

        @Column(name="member_sysname")
        private String member_sysname;

}
