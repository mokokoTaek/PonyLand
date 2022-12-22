package PonyLand.PonyLand.dto;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicInsert
@DynamicUpdate
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
@SequenceGenerator(
        name = "item_seq_generator"
        , sequenceName = "item_seq"
        , initialValue = 1
        , allocationSize = 1
)
public class ItemDTO {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "item_seq_generator"
    )
    @Column(name = "item_seq")
    private int itemSeq;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_member_id")
    private String itemMemberId;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "item_x")
    private int itemX;

    @Column(name = "item_y")
    private int itemY;

    @Column(name = "item_status")
    private int itemStatus;

}
