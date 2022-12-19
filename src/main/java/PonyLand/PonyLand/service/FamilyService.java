package PonyLand.PonyLand.service;

import PonyLand.PonyLand.dao.FamilyDAO;
import PonyLand.PonyLand.dao.MemberDAO;
import PonyLand.PonyLand.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class FamilyService {

    @Autowired
    private FamilyDAO dao;

    @Autowired
    private MemberDAO mdao;

    public int getFamily(int result, String familyProposerId, String familyProposedId,String familyMe,String familyOther) throws IOException {
        int familyStatus = 0;
        if (result == 2) {

            dao.getFamily(familyProposerId,familyProposedId,familyMe,familyOther,familyStatus,mdao.findById(familyProposerId).getMember_name(),
                    mdao.findById(familyProposedId).getMember_name());
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

    public int areTheyFamily(String familyProposerId, String familyProposedId) {
        FamilyDTO dto1 = dao.areTheyFamily(familyProposerId,familyProposedId);
        FamilyDTO dto2 = dao.areTheyFamily(familyProposedId,familyProposerId);

        if ((dto1 != null) && (dto2 != null)) {
            return 1;
        } else if ((dto1 == null) && (dto2==null) ) {
            return 2;
        } else if ((dto1==null) && (dto2!=null)){
            return 3;
        }
        return 0;
    }

    public List<FamilyDTO> checkNewFamily(String familyProposedId,int familyStatus){
        return dao.checkNewFamily(familyProposedId,familyStatus);
    }

    public FamilyDTO agreeFamily(int familySeq){
        FamilyDTO dto = dao.findByFamilySeq(familySeq);

        return dto;

    }

    public void deleteByFamilySeq(int familySeq){
        dao.deleteByFamilySeq(familySeq);
    }

    public List<FamilyDTO> getFamilyListByProposerId(String id){
        return dao.getFamilyListByProposerId(id);
    }

    public List<FamilyDTO> getFamilyListByProposedId(String id){
        return dao.getFamilyListByProposedId(id);
    }
}