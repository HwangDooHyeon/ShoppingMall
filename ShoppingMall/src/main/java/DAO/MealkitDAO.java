package DAO;

public interface MealkitDAO {

    public interface SceneDAO {
        public void createTable();

        public void create();

        public void findAll();

        public void findbyCategory();

        public void findbyName();

        public void findbyPrice();

        public void updateAll();

        public void updateName();

        public void updateCategory();

        public void updatePrice();

        public void updateInfo();

        public void delete();

    }
}
