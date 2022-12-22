package PonyLand.PonyLand.Repository.item;

import javax.persistence.EntityManager;

public class JpaItemRepository implements ItemRepository{
    private final EntityManager em;

    public JpaItemRepository(EntityManager em) {
        this.em = em;
    }
}
