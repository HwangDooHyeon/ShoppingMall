package DAO;

import OBJ.Mealkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MealkitDAOImplement implements MealkitDAO {
    private Connection connection = null;

    private MealkitDAOImplement() {
    }

    public static MealkitDAOImplement getInstance() {
        return getInstance();
    }


    public void createTable() {
        String tableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "MealPrice INT NOT NULL, " +
                "MealName VARCHAR(255) NOT NULL, " +
                "MealCategory VARCHAR(255) NOT NULL, " +
                "MealInfo VARCHAR(255) NOT NULL)";
    }

    public void create() {
        String insertSQL = "INSERT INTO Mealkit (MealPrice, MealName, MealCategory, MealInfo) VALUES (?, ?, ?, ?)";
//        PreparedStatement insertStatement = connection.prepareStatement(insertSQL);}
    }

    public void findAll() {
    }

    public void findbyCategory() {
    }

    public void findbyName(String mealName) {
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

        } catch (SQLException e) {
            e.getMessage();
        }
    }


    public void findbyPrice(int MealPrice) {
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

        } catch (SQLException e) {
            e.getMessage();
        }
    }
}

//            public void updateAll(){}
//
//            public void updateName(){}
//
//            public void updateCategory(){}
//
//            public void updatePrice(){}
//
//            public void updateInfo(){}
//
//            public void delete(){}