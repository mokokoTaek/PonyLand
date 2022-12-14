package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.MemberDAO;
import PonyLand.PonyLand.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

@Service
public class MemberService {

    @Autowired
    private MemberDAO dao;
    @Autowired
    private Random random;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpSession session;

    public Long getWave() {
        return dao.countMember();
    }

    public int getRandom(Long countMember) {

        int intCountMember = countMember.intValue();
        return (int) (Math.random() * intCountMember + 1);

    }
    public String toWave(int rn){
        return dao.getIdByRowNum(rn);
    }

    public void insert(MemberDTO dto) {
        dao.insert(dto);
    }

    public String login( String member_id, String member_pw) throws Exception {
        MemberDTO dto = dao.login(member_id, member_pw);
        if (dto == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('아이디와 패스워드를 확인해 주세요.'); history.go(-1);</script>");
            out.flush();
            response.flushBuffer();
            out.close();
        } else {
            return "redirect:/";
        }
        return "redirect:/";
    }

    public MemberDTO makeIdAndPwByEmail(String email){

        int index= email.indexOf("@");

        String newId = email.substring(0,index);

        UUID uuid = UUID.randomUUID();

        String newPw = uuid.toString() + newId;

        MemberDTO dto = new MemberDTO();
        dto.setMemberId(newId);
        dto.setMemberPw(newPw);
        dto.setMember_email(email);
        dto.setMemberLoginType("kakao");

        if(dao.loginForKakao(newId)==null){
            dao.insert(dto);
        }
        session.setAttribute("sessionID",dto.getMemberId());
        return dto;
    }

    public void logout() throws IOException {

        String id = (String)session.getAttribute("sessionID");

       if(dao.loginForKakao(id).getMemberLoginType().equals("kakao")){
            System.out.println("이것은 카카오 아이디!");
        }

        session.invalidate();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('로그아웃 되었습니다.'); location.href='/';</script>");
        out.flush();
        response.flushBuffer();
        out.close();
    }
}




