package Service;

import DAO.MealkitDAOImplement;
import DTO.MealkitDTO;
import OBJ.Mealkit;

import java.util.List;

public class MealkitService {

    public MealkitService() {
        MealkitDAOImplement.getInstance().createTable();
    }

//    public List<Mealkit> findAll() {
//        return MealkitDAOImplement.getInstance().findAll();
//    }
//    public Mealkit findbyCategory(String mealCategory){
//        return MealkitDAOImplement.getInstance().findbyCategory(mealCategory);
//    }
//
//    public Mealkit findbyName(String mealName){
//        return MealkitDAOImplement.getInstance().findbyName(mealName);
//    }
//
//    public Mealkit findbyPrice(int mealPrice){
//        return MealkitDAOImplement.getInstance().findbyPrice(mealPrice);
//    }
//

}
