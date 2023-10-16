package DAO;

import OBJ.Mealkit;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MealkitDAOImplement implements MealkitDAO {
    public void createTable() { }
    public void create() { }
    public void updateuser(){ }
    public void delete(){ }

    private Connection connection = null;

    private static MealkitDAOImplement instance = new MealkitDAOImplement();
    private MealkitDAOImplement() {}
    public static MealkitDAOImplement getInstance() {return instance;}

    public void createTable() {
        String tableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "MealPrice INT NOT NULL, " +
                "MealName VARCHAR(255) NOT NULL, " +
                "MealCategory VARCHAR(255) NOT NULL, " +
                "MealInfo VARCHAR(255) NOT NULL)";
    }

    public void create(Mealkit mealkit){
        String insertSQL = "INSERT INTO Mealkit (MealPrice, MealName, MealCategory, MealInfo) VALUES (?, ?, ?, ?)";
//        PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
    }

    public void findAll(){}

    public void findbyCategory(){}

    public List<Mealkit> findbyName(String MealName){
            String selectSQL = "SELECT * FROM Mealkit WHERE MealName=?";

            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSQL);

                List<Mealkit> mealkit = new ArrayList<>();

                while (resultSet.next()) {
                    mealkit.add(
                            new Mealkit(resultSet.getString("MealName")));
                }

                resultSet.close();

                return mealkit;

            } catch (SQLException e) {
                e.getMessage();
                return Collections.emptyList();
            }
        }

    public List<Mealkit> findbyPrice(int MealPrice){
        String selectSQL = "SELECT * FROM Mealkit WHERE MealPrice=?";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            List<Mealkit> mealkit = new ArrayList<>();

            while (resultSet.next()) {
                mealkit.add(
                        new Mealkit(resultSet.getInt("MealPrice")));
            }

            resultSet.close();

            return mealkit;

        } catch (SQLException e) {
            e.getMessage();
            return Collections.emptyList();
        }
    }

    public void updateMealkit(){

    }

    public void delete(Long Id){
        String selectSQL = "DELETE FROM Mealkit WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, Id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }

    }

>>>>>>> Stashed changes
}
