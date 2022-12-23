package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.AlbumDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.AlbumService;
import PonyLand.PonyLand.service.GuestbookService;
import PonyLand.PonyLand.service.ItemService;
import PonyLand.PonyLand.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/toMiniPage")
    public String miniHome(String id, Model model){

        MemberDTO dto =service.findById(id);

        int dto1 = albumService.count();  //album 게시글 총 갯수 가져오기

        int dto2 = guestbookService.count();//Guestbook  게시글 총 갯수 가져오기

        List<AlbumDTO> dto3 = albumService.select(); //main에 최근 사진첩 게시글 제목 뽑아오기
        List<AlbumDTO> dto4 = albumService.selectAll(); // 게시글 리스트를 가져와야 뽑아와지더라고요?


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -7); //7일간 보이도록 하기위해서.
        String nowday = format.format(cal.getTime());

        model.addAttribute("nowday",nowday);

        String horse = "horse";
        String bg = "background";

        model.addAttribute("miniroomdto",service.findById(id));

        model.addAttribute("nowdto", service2.findByItemStatus(id,horse));
        model.addAttribute("nowbgdto", service2.findByItemStatus(id,bg));
        model.addAttribute("dto",dto);
        model.addAttribute("id",id);
        model.addAttribute("sessionID",session.getAttribute("sessionID"));
        model.addAttribute("list",dto);
        model.addAttribute("list1",dto1);  //album 게시글 총 갯수 뿌림.
        model.addAttribute("list2",dto2); //Guestbook 게시글 총 갯수 뿌림.
        model.addAttribute("list3",dto3);  //main에 최근 사진첩 게시글 제목 뿌리기.

        System.out.println(service2.findByItemStatus(id,bg).getItemName());
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
