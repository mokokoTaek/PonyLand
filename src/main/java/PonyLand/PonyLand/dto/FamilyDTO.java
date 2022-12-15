package PonyLand.PonyLand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
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
    private int familySeq;

    @Column(name="family_proposer_id")
    private String familyProposerId;

    @Column(name="family_proposed_id")
    private String familyProposedId;

    @Column(name="family_me")
    private String familyMe;

    @Column(name = "family_other")
    private String familyOther;

    @Column(name="family_status")
    private int familyStatus;

    @Column(name = "family_proposer_name")
    private String familyProposerName;

    @Column(name = "family_proposed_name")
    private String familyProposedName;
}
