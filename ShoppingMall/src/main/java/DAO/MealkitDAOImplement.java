package DAO;

public class MealkitDAOImplement implements MealkitDAO {

    private static MealkitDAOImplement instance = new MealkitDAOImplement();
    private MealkitDAOImplement() {}
    public static MealkitDAOImplement getInstance() {return instance;}

    public void createTable() {

    }

    public void create(){};

    public void findAll(){};

    public void findbyCategory(){};

    public void findbyName(){};

    public void findbyPrice(){};

    public void updateMealkit(){

    };

    public void delete(){};

}
