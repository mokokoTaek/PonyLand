package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.ItemDAO;
import PonyLand.PonyLand.dto.ItemDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDAO dao;

    public List<ItemDTO> findHorseById(String itemMeberId){
        String itemCategory = "horse";
        return dao.findHorseById(itemMeberId,itemCategory);
    }

    public List<ItemDTO> findBgById(String itemMeberId){
        String itemCategory = "background";
        return dao.findHorseById(itemMeberId,itemCategory);
    }
    public List<ItemDTO> findFurnitureById(String itemMeberId){
        String itemCategory = "furniture";
        return dao.findHorseById(itemMeberId,itemCategory);
    }

    public void updateItem(ItemDTO dto){
        dto.setItemStatus(1);
        dao.updateItem(dto);
    }

    public List<ItemDTO> furnitureListControl(List list){
        List<ItemDTO> furnitureItemList = new ArrayList<ItemDTO>();
        for(int i=0;i<list.size();i++){
            furnitureItemList.add(this.findByItemSeq((String)list.get(i)));
        }
        return furnitureItemList;
    }
    public ItemDTO findByItemSeq(String itemSeq){
        int seq = Integer.parseInt(itemSeq);
        return dao.findByItemSeq(seq);
    }

    public void updateOtherStatus(String imgSeq,String itemCategory){
        int itemSeq = Integer.parseInt(imgSeq);
        dao.updateOtherStatus(itemSeq,itemCategory);
    }

    public ItemDTO findByItemStatus(String id,String itemCategory){
        int itemStatus = 1;
        return dao.findByItemStatus(id,itemStatus,itemCategory);
    }

    public List<ItemDTO> findFurnitureByItemStatus(String id, String itemCategory){
        int itemStatus = 1;
        return dao.findFurnitureByItemStatus(id,itemStatus,itemCategory);
    }

    public void updateCoordinate(ItemDTO dto){
        dao.updateCoordinate(dto);
    }

    public void newUser(MemberDTO dto){
        ItemDTO itemHorseDto = new ItemDTO(0,"thumbmokoko.png",dto.getMemberId(),"horse",206,179,1);
        ItemDTO itemBgDto = new ItemDTO(0,"snow.gif",dto.getMemberId(),"background",0,0,1);
        dao.newUser(itemHorseDto,itemBgDto);
    }
}
