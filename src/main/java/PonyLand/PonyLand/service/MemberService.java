package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.MemberDAO;
import PonyLand.PonyLand.dto.MemberDTO;
import PonyLand.PonyLand.dto.RacingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class MemberService {

    private final static String VIEWCOOKIENAME = "alreadyViewCookie";

    @Autowired
    private MemberDAO dao;
    @Autowired
    private Random random;
    @Autowired
    private ItemService itemService;
    @Autowired
    private HttpSession session;

    public MemberDTO getInfo(String memberId){return dao.getInfo(memberId);}

    public List<String> selectId(String id){
        List<String> list = new ArrayList<>();
        list.add(0,id);
        return list;
    }

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
        dto.setMember_coin(500);
        System.out.println("!!!!!");
        System.out.println(dto.getMember_coin());

        dao.insert(dto);
    }

    public void updateCoin(MemberDTO dto){
        dao.insert(dto);
    }

    public String login( String member_id, String member_pw) throws Exception {
        MemberDTO dto = dao.login(member_id, member_pw);
        if (dto == null) {
            HttpServletResponse response = null;
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('???????????? ??????????????? ????????? ?????????.'); history.go(-1);</script>");
            out.flush();
            response.flushBuffer();
            out.close();
        } else {
            return "redirect:/";
        }
        return "redirect:/";
    }

    public MemberDTO makeIdAndPwByEmailForKakao(String name, String email){

        int index= email.indexOf("@");

        String newId = "K"+email.substring(0,index);

        UUID uuid = UUID.randomUUID();

        String newPw = uuid.toString() + newId;

        MemberDTO dto = new MemberDTO();
        dto.setMemberId(newId);
        dto.setMemberPw(newPw);
        dto.setMember_email(email);
        dto.setMember_name(name);
        dto.setMemberLoginType("kakao");

        if(dao.loginForKakao(newId)==null){
            dao.insert(dto);

            itemService.newUser(dto);

        }
        session.setAttribute("sessionID",dto.getMemberId());
        return dto;
    }

    public MemberDTO makeIdAndPwByEmailForNaver(String name, String email){

        int index= email.indexOf("@");

        String newId = "N"+email.substring(0,index);

        UUID uuid = UUID.randomUUID();

        String newPw = uuid.toString() + newId;

        MemberDTO dto = new MemberDTO();
        dto.setMemberId(newId);
        dto.setMemberPw(newPw);
        dto.setMember_email(email);
        dto.setMember_name(name);
        dto.setMemberLoginType("naver");

        if(dao.loginForKakao(newId)==null){
            dao.insert(dto);

            itemService.newUser(dto);

        }
        session.setAttribute("sessionID",dto.getMemberId());
        return dto;
    }




    public void logout() throws IOException {

        String id = (String)session.getAttribute("sessionID");

        if(dao.loginForKakao(id).getMemberLoginType().equals("kakao")){
            System.out.println("????????? ????????? ?????????!");
        }

        session.invalidate();
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("<script>alert('???????????? ???????????????.'); location.href='/';</script>");
//        out.flush();
//        response.flushBuffer();
//        out.close();
    }

    public MemberDTO findById(String id){
        return dao.findById(id);
    }

    public void addView(String id, HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        boolean checkCookie = false;
        if(cookies != null){
            for (Cookie cookie : cookies)
            {
                // ?????? ????????? ??? ?????? ??????
                if (cookie.getName().equals(VIEWCOOKIENAME+id)) checkCookie = true;

            }
            if(!checkCookie){
                Cookie newCookie = createCookieForForNotOverlap(id);
                response.addCookie(newCookie);
                dao.addView(id);
            }
        } else {
            Cookie newCookie = createCookieForForNotOverlap(id);
            response.addCookie(newCookie);
            dao.addView(id);
        }

    }

    /*
     * ????????? ?????? ????????? ?????? ?????? ?????? ?????????
     * @param cookie
     * @return
     * */
    private Cookie createCookieForForNotOverlap(String id) {
        Cookie cookie = new Cookie(VIEWCOOKIENAME+id, id);
        cookie.setComment("????????? ?????? ?????? ?????? ??????");	// ?????? ?????? ?????? ??????
        cookie.setMaxAge(getRemainSecondForTommorow()); 	// ????????? ??????.
        cookie.setHttpOnly(true);				// ??????????????? ?????? ??????
        return cookie;
    }

    // ?????? ??? ???????????? ?????? ??????(???)
    private int getRemainSecondForTommorow() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tommorow = LocalDateTime.now().plusDays(1L).truncatedTo(ChronoUnit.DAYS);
        return (int) now.until(tommorow, ChronoUnit.SECONDS);
    }

    public int update(MemberDTO dto) {
        return dao.update(dto);
    }
    public void imgupdate(MemberDTO dto) {
        System.out.println(dto);
        dao.imgupdate(dto);

    }
    public void message(MemberDTO dto) {
         dao.message(dto);
    }


    // ???????????? ????????? ???????????? ?????? ?????? ??????
    public double bettingCoin(String id, int bettingCoin, int horseCount, String betHorse) {
        Map<String, Object> map = new HashMap<>();

        map.put("racing_id", id);
        map.put("racing_seq", betHorse);
        map.put("bettingCoin",bettingCoin);

        if (horseCount == 2) {
            double sum = bettingCoin * 1.5;
            map.put("racing_coin", sum);
            dao.updateCoin(map);
            return sum;
        } else if (horseCount == 3) {
            double sum = bettingCoin * 2;
            map.put("racing_coin", sum);
            dao.updateCoin(map);
            return sum;

        } else {
            double sum = bettingCoin * 2;
            map.put("racing_coin", sum);
            dao.updateCoin(map);
            return sum;
        }

    }
    // ????????? ?????? ????????? ajax??? ????????? ???????????? ??????
    public double add(int bettingCoin, int horseCount) {
        double sum;
        if (horseCount == 2) {
            sum = bettingCoin * 1.5;
            return sum;

        } else if (horseCount == 3) {
            sum = bettingCoin * 2;
            return sum;

        } else {
            sum = bettingCoin * 2;
            return sum;
        }
    }

    // racing ???????????? ?????? ????????? ??? ????????? ?????? ???????????? select ???
    public RacingDTO selectBet(String id){
        return dao.selectBet(id);
    }

    //???????????? member?????? coin ???????????? ?????? ???
    public void updateWin(RacingDTO dto) {
        dao.updateWin(dto);
    }

    // ????????? member?????? coin ???????????? ?????? ???
   /* public void updateLose(RacingDTO dto) {
        dao.updateLose(dto);
    }*/

    // ????????? ???????????? ???????????? ?????? ?????? ???
    public void deleteBet(String id) {
        dao.deleteBet(id);
    }
    public boolean duplCheck(String memberId) {
        return dao.duplCheck(memberId);
    }


    //racing ???????????? insert?????? ??????
    public void insertRacing(String racingId, int racingHorseSeq, double racingCoin, int bettingCoin) {
        Map<String, Object> map = new HashMap<>();
        map.put("racing_id",racingId);
        map.put("racing_horse_seq", racingHorseSeq);
        map.put("racing_coin",racingCoin);
        map.put("bettingCoin",bettingCoin);
        dao.insertCoin(map);
    }





}







