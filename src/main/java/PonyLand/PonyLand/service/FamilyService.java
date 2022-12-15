package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.FamilyDAO;
import PonyLand.PonyLand.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class FamilyService {

    @Autowired
    private FamilyDAO dao;



    @RequestMapping("/getFamily")
    public int getFamily(int result, String familyProposerId, String familyProposedId) throws IOException {
        if (result == 2) {
            dao.getFamily(familyProposerId,familyProposedId);
            return 2;
        } else if (result == 1) {
            return 1;
        } else if (result==3){
            return 3;
        }
        else {
            return 0;
        }
    }

    @RequestMapping
    public int areTheyFamily(String familyProposerId, String familyProposedId) {
        FamilyDTO dto1 = dao.areTheyFamily(familyProposerId,familyProposedId);
        FamilyDTO dto2 = dao.areTheyFamily(familyProposedId,familyProposerId);

        if ((dto1 != null) && (dto2 != null)) {
            return 1;
        } else if (dto1 == null) {
            return 2;
        } else if ((dto1==null) && (dto2!=null)){
            return 3;
        }
        return 0;
    }
}