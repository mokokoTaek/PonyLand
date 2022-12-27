package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dto.ItemDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Service
public class ShopService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private HttpSession session;

    public boolean buy(MemberDTO dto, String price,String product, String category){

        String id = (String)session.getAttribute("sessionID");
        int intPrice = Integer.parseInt(price);
        if(dto.getMember_coin() >= intPrice){

            boolean isExist = itemService.addNewItem(new ItemDTO(0,product,id,category,206,179,0));

            if(isExist==false){
                return false;
            }else{
                dto.setMember_coin(dto.getMember_coin()-intPrice);
                memberService.insert(dto);

                return true;
            }

        }else{
          return false;
        }
    }


    public int wish(String product, String price){

        int intPrice = Integer.parseInt(price);
        return intPrice;
    }
}
