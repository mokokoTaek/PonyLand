package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Service
public class MemberService {

    @Autowired
    private MemberDAO dao;

    @Autowired
    private Random random;

    public Long getWave(){
        return dao.countMember();
    }

    public int getRandom(Long countMember){

        int intCountMember = countMember.intValue();
        return (int) (Math.random() * intCountMember + 1);

    }
}
