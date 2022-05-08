package BLL;

import BE.Citizen;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;
import java.util.List;

public class CitizenManager {
    FacadeDAL facadeDAL = new FacadeDAL();

    public CitizenManager() throws IOException {
    }

    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return facadeDAL.getAllCitizenFromOneSchool(schoolId);
    }
}
