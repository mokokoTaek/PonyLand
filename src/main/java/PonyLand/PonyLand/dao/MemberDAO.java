package PonyLand.PonyLand.dao;

import PonyLand.PonyLand.Repository.SpringDataJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private SpringDataJpaMemberRepository sdjr;


}
