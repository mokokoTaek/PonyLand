package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.ItemDAO;
import PonyLand.PonyLand.dto.ItemDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDAO dao;

    @Autowired
    private HttpSession session;

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

        public boolean addNewItem(ItemDTO dto){
        List<ItemDTO> horseList = dao.findHorseById(dto.getItemMemberId(),dto.getItemCategory());
        List<ItemDTO> bgList = dao.findBgById(dto.getItemMemberId(),dto.getItemCategory());

        for(int i=0;i<horseList.size();i++) {
            if (horseList.get(i).getItemName().equals(dto.getItemName())) {
                return false;
            }
        }

            for(int i=0;i<bgList.size();i++) {
                if (horseList.get(i).getItemName().equals(dto.getItemName())) {
                    return false;
                }
            }

        dao.updateItem(dto);
            return true;
    }



    public List<ItemDTO> furnitureListControl(List list){
        String id = (String)session.getAttribute("sessionID");

        List<ItemDTO> alreadyUsing = this.findFurnitureByItemStatus(id,"furniture");
        List<ItemDTO> newFurniture = this.findFurnitureById(id);
        for(int i=0; i<alreadyUsing.size();i++){
            alreadyUsing.get(i).setItemStatus(0);
        }

        List<ItemDTO> furnitureItemList = new ArrayList<ItemDTO>();
        for(int i=0;i<list.size();i++){
            furnitureItemList.add(this.findByItemSeq((String)list.get(i)));

            for(int j=0;j<newFurniture.size();j++){
                if(newFurniture.get(j).getItemName().equals(furnitureItemList.get(i).getItemName())){
                    newFurniture.get(i).setItemStatus(1);
                    this.updateItem(newFurniture.get(i));
                }
            }

//            System.out.println(furnitureItemList.get(i).getItemName());
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
        ItemDTO itemFurnitureDto = new ItemDTO(0,"defaultfurniture.png",dto.getMemberId(),"furniture",100,100,1);
        dao.newUser(itemHorseDto,itemBgDto,itemFurnitureDto);
    }
}
