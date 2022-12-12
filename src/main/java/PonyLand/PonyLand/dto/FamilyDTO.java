package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family")
@SequenceGenerator(
        name = "family_seq_generator"
        , sequenceName = "family_seq"
        , initialValue = 1
        , allocationSize = 1
)
public class FamilyDTO {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
            , generator = "family_seq_generator"
    )
    @Column(name = "family_seq")
    private int family_seq;

    @Column(name="family_proposer_id")
    private String family_proposer_id;

    @Column(name="family_proposed_id")
    private String family_proposed_id;
}
