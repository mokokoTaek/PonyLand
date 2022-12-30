package PonyLand.PonyLand.Repository.item;

import PonyLand.PonyLand.dto.ItemDTO;
import org.apache.ibatis.annotations.Param;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SpringDataJpaItemRepository extends JpaRepository<ItemDTO, Integer> {

    @Transactional
    List<ItemDTO> findAllByItemMemberIdAndItemCategory(String itemMeberId, String itemCategory);

    @Transactional
    ItemDTO findByItemSeq(int itemSeq);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(nativeQuery = true, value = "update item set item_status=0 where item_category=:itemCategory and not item_seq=:itemSeq")
    void updateOtherStatus(@Param("itemSeq") int itemSeq, @Param("itemCategory") String itemCategory);



    @Transactional
    ItemDTO findByItemMemberIdAndItemStatusAndItemCategory(String itemMemberId, int itemStatus, String itemCategory);

    @Transactional
    List<ItemDTO> findAllByItemMemberIdAndItemStatusAndItemCategory(String itemMemberId, int itemStatus, String itemCategory);
}
