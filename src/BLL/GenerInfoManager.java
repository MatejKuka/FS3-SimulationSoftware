package BLL;

import BE.GeneralInfo;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;

public class GenerInfoManager {
    FacadeDAL facadeDAL;

    public GenerInfoManager() throws IOException {
        facadeDAL = new FacadeDAL();
    }

    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return facadeDAL.getGeneralInfo(idGeneralInfo);
    }
}
