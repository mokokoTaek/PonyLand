package PonyLand.PonyLand.Repository.Family;

import javax.persistence.EntityManager;

public class JpaFamilyRepository implements FamilyRepository{
    private final EntityManager em;

    public JpaFamilyRepository(EntityManager em) {
        this.em = em;
    }
}
