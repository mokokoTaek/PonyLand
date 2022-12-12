package PonyLand.PonyLand.Repository;

import javax.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
}
