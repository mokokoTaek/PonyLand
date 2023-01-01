package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.AlbumDTO;
import PonyLand.PonyLand.dto.HistoryDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HttpSession session;

    @Autowired
    private MemberService service;

    @Autowired
    private ItemService service2;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private GuestbookService guestbookService;

    @Autowired
    private HistoryService historyService;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/toMiniPage")
    public String miniHome(String id, Model model){

        MemberDTO dto =service.findById(id);

        int dto1 = albumService.count(id);  //album 게시글 총 갯수 가져오기 , 사진첩은 나밖에못쓰므로 writer랑,id이 값 같아서 id로 가져옴.

        int dto2 = guestbookService.count(id);// Guestbook  게시글 총 갯수 가져오기 ,id값 받아서 가져옴.

        List<AlbumDTO> dto3 = albumService.select(); // main에 최근 사진첩 게시글 제목 뽑아오기

        int dto4  = albumService.selectByDate(id);  // 사진첩 하루안에 올린 글 갯수

        int dto5 = guestbookService.selectByDate(id);// 방명록 하루안에 올리 글 갯수

        List<HistoryDTO> historyDTOList = historyService.selectId(); // History 목록 뿌리기
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, -7); //7일간 보이도록 하기위해서.
//        String nowday = format.format(cal.getTime());
//
//        model.addAttribute("nowday",nowday);

        String horse = "horse";
        String bg = "background";
        String furniture = "furniture";

        model.addAttribute("dto",dto);
        model.addAttribute("id",id);
        model.addAttribute("sessionID",session.getAttribute("sessionID"));
        model.addAttribute("list",dto);
        model.addAttribute("list1",dto1);  //album 게시글 총 갯수 뿌림.
        model.addAttribute("list2",dto2); //Guestbook 게시글 총 갯수 뿌림.
        model.addAttribute("list3",dto3);  //main에 최근 사진첩 게시글 제목 뿌리기.
        model.addAttribute("list4",dto4);// 사진첩 하루안에 올린 글 갯수
        model.addAttribute("list5",dto5); //방명록 하루안에 올린 글 갯수
        model.addAttribute("miniroomdto",service.findById(id));
        model.addAttribute("nowdto", service2.findByItemStatus(id,horse));
        model.addAttribute("nowbgdto", service2.findByItemStatus(id,bg));
        model.addAttribute("nowfurniturelist", service2.findFurnitureByItemStatus(id,furniture));
        model.addAttribute("historyDTOList", historyDTOList); // history 기록 메인에 뿌리기
        return "main";
    }
    @RequestMapping("history")
    public String history(String memberId, Model model){
        List<String> list = service.selectId(memberId);
        model.addAttribute("list", list);
        return "main";
    }

    @GetMapping("/toAlbumPage")
    public String AlbumPage(){
        return "album";
    }

    @GetMapping("/signin")
    public String insert(){
        return "signin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/toFamilyOpen")
    public String toFamilyOpen(){return "familyOpen";}

    @GetMapping("/toCheckNewFamilyOpen")
    public String toCheckNewFamilyOpen(){return "checkNewFamilyOpen";}

    @RequestMapping("/toFamilyListOpen")
    public String toFamilyListOpen(){return "redirect:/family/familyListOpen";}


}
