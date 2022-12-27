package PonyLand.PonyLand.controller;

import PonyLand.PonyLand.dto.ItemDTO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.service.ItemService;
import PonyLand.PonyLand.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/member/")
public class MemberController {

    @Autowired
    MemberService service;
    @Autowired
    ItemService itemService;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletResponse response;
    @GetMapping("wave")

    @RequestMapping("wave")
    public String getWave(Model model,HttpServletRequest request, HttpServletResponse response){

        Long countMember = service.getWave();
        int randomNumber = service.getRandom(countMember);

        String id = service.toWave(randomNumber);
        System.out.println("!!!!");
        System.out.println(id);
        service.addView(id,request,response);

        MemberDTO dto = service.findById(id);

        model.addAttribute("nowdto", itemService.findByItemStatus(id,"horse"));
        model.addAttribute("nowbgdto", itemService.findByItemStatus(id,"background"));
        model.addAttribute("dto",dto);
        model.addAttribute("id",id);
        model.addAttribute("sessionID",session.getAttribute("sessionID"));

        return "main";
    }
    @PostMapping("insert")
    public String insert(MemberDTO dto){
        service.insert(dto);
        itemService.newUser(dto);
        System.out.println(dto.getMemberPw());
        return "redirect:/";
    }

    @RequestMapping("duplCheck")
    @ResponseBody
    public boolean duplCheck(@RequestParam("member_id") String memberId) {
        return service.duplCheck(memberId);
    }


    @RequestMapping("login")
    public String login(MemberDTO dto, Model model) throws Exception{
        service.login(dto.getMemberId(), dto.getMemberPw());
        session.setAttribute("sessionID", dto.getMemberId());
        model.addAttribute("id", dto.getMemberId());
        return "index";
    }


    @GetMapping ("logout")
    public String logout() throws Exception{
        service.logout();
        return "index";
    }

    @RequestMapping("signinForKakao")
    public String signinForKakao(String name,String email,Model model){

        MemberDTO dto = service.makeIdAndPwByEmailForKakao(name,email);
        model.addAttribute("id",dto.getMemberId());
        itemService.newUser(dto);
        return "index";
    }

    @RequestMapping("areYouKakao")
    @ResponseBody
    public String areYouKakao(String id){
        return service.findById(id).getMemberLoginType();
    }


    @RequestMapping("signinForNaver")
    public String singinForNaver(Model model, String name, String email){

        MemberDTO dto =service.makeIdAndPwByEmailForNaver(name,email);
       model.addAttribute("id",dto.getMemberId());
        itemService.newUser(dto);
        return "index";
    }
    @RequestMapping("goMypage")
    public String goMypage(MemberDTO dto1,Model model){  //마이페이지에 DTO를 이용하여 id를 가져온다.
        MemberDTO dto = service.findById(dto1.getMemberId()); //dto1에서 아이디를 가져와서 dto에담아준다
        model.addAttribute("id",dto.getMemberId()); //id를 dto에 담아줌.
        model.addAttribute("list",dto);// dto를 list로 묶어서 배포.
        return "mypage";
    }
    @RequestMapping("modify")
    public String modify(MemberDTO dto) {
        service.update(dto);

        return "redirect:/member/goMypage?&memberId="+dto.getMemberId();

    }

    @RequestMapping("message")
    public String message(MemberDTO dto) {
        service.message(dto);
        return "redirect:/toMiniPage?&id="+dto.getMemberId();
    }

    @RequestMapping("imgupdate")
    public String imgupdate(MultipartFile files, MemberDTO dto,Model model )throws Exception{

//        try {
            String memberId = (String) session.getAttribute("sessionID");
            dto.setMemberId(memberId); //id.
            String realPath = session.getServletContext().getRealPath("load");
            System.out.println(realPath);
            //리얼패스 내부에 파일이존재하는 경로를 가져옴.
            File filePath = new File(realPath);
            if (!filePath.exists()) {
                filePath.mkdir();  //업로드 폴더가 없으면 생성함.

            }
            System.out.println("1");
            //여기서부터 문제
            String oriName = files.getOriginalFilename();  //클라이언트는 자신이 선택이름을 가진 파일을 받길원함.
            dto.setMember_oriname(oriName); //dto에 사진담고

            System.out.println("2");
            System.out.println(oriName);


            String sysName = UUID.randomUUID().randomUUID() + "_" + oriName; // 서버는 클라이언트가 선택한 파일의 서버쪽 이름이 필요하다
            dto.setMember_sysname(sysName); // 사진담고
            System.out.println(sysName);
            //oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");  //한글화.

            files.transferTo(new File(filePath + "/" + sysName)); //우리가 사용할 파일의 정보를 담음.

            model.addAttribute("list",dto);
            service.imgupdate(dto);

//        }catch(Exception e){
//            return "error";
//        }

        return "redirect:/member/goMypage?&memberId="+dto.getMemberId();

    }






}
