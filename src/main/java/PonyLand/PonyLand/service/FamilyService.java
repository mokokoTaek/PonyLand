package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.FamilyDAO;
import PonyLand.PonyLand.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class FamilyService {

    @Autowired
    private FamilyDAO dao;

    @RequestMapping
    public void getFamily(FamilyDTO dto){
        dao.getFamily(dto);
    }

}
