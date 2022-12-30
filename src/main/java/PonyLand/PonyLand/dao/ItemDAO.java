package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Repository.item.SpringDataJpaItemRepository;
import PonyLand.PonyLand.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAO {

    @Autowired
    private SpringDataJpaItemRepository sdjr;

    public List<ItemDTO> findHorseById(String itemMemberId, String itemCategory){
        return sdjr.findAllByItemMemberIdAndItemCategory(itemMemberId,itemCategory);
    }

    public List<ItemDTO> findBgById(String itemMemberId, String itemCategory){
        return sdjr.findAllByItemMemberIdAndItemCategory(itemMemberId,itemCategory);
    }

    public void updateItem(ItemDTO dto){
        sdjr.save(dto);
    }

    public ItemDTO findByItemSeq(int itemSeq){
        return sdjr.findByItemSeq(itemSeq);
    }

    public void updateOtherStatus(int itemSeq,String itemCateogry){
        sdjr.updateOtherStatus(itemSeq,itemCateogry);
    }

    public ItemDTO findByItemStatus(String id, int itemStatus, String itemCategory){

        return sdjr.findByItemMemberIdAndItemStatusAndItemCategory(id,itemStatus,itemCategory);
    }
    public List<ItemDTO> findFurnitureByItemStatus(String id, int itemStatus, String itemCategory){

        return sdjr.findAllByItemMemberIdAndItemStatusAndItemCategory(id,itemStatus,itemCategory);
    }
    public void updateCoordinate(ItemDTO dto){
        sdjr.save(dto);
    }

    public void newUser(ItemDTO horse, ItemDTO bg, ItemDTO furniture){

        System.out.println("@@@@@@@@@@@@@@####");
        System.out.println(horse.getItemStatus());
        System.out.println(bg.getItemStatus());
        System.out.println(furniture.getItemStatus());

        sdjr.save(horse);
        sdjr.save(bg);
        sdjr.save(furniture);
    }

}
