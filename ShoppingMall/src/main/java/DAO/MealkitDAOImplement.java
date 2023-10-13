package DAO;

import OBJ.Mealkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MealkitDAOImplement implements MealkitDAO {

    private static MealkitDAOImplement instance = new MealkitDAOImplement();
    private MealkitDAOImplement() {}
    public static MealkitDAOImplement getInstance() {return instance;}

    private Connection connection = null;

    public void createTable() {
        String tableSQL = "CREATE TABLE IF NOT EXISTS Mealkit (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "MealName VARCHAR(255) NOT NULL," +
                "MealCategory VARCHAR(255) NOT NULL," +
                "MealPrice VARCHAR(255) NOT NULL," +
                "MealInfo VARCHAR(255) NOT NULL)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(tableSQL)) {
                statement.execute();
            }
        }catch (SQLException e) {
            e.getMessage();
        }
    }

    public void create(Mealkit mealkit){
        try {
            String insertSQL = "INSERT INTO Mealkit (MealName, MealCategory, MealPrice, MealInfo) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);

            insertStatement.setString(1, mealkit.getMealName());
            insertStatement.setString(2, mealkit.getMealCategory());
            insertStatement.setInt(3, mealkit.getMealPrice());
            insertStatement.setString(4, mealkit.getMealInfo());

            insertStatement.execute();
            insertStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void findAll(){};

    public void findbyCategory(){};

    public void findbyName(){};

    public void findbyPrice(){};

    public void updateMealkit(){

    };

    public void delete(){};

}
