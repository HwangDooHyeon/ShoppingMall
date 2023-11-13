package DAO;

import DTO.MealkitDTO;
import OBJ.Mealkit;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MealkitDAOImplement implements MealkitDAO {

    private static MealkitDAOImplement instance = new MealkitDAOImplement();

    private MealkitDAOImplement(){}

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

    public Mealkit findById(Long ID) {
        String selectSQL = "SELECT * FROM MealkitDTO WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Mealkit(
                        resultSet.getLong("MealID"),
                        resultSet.getString("MealName"),
                        resultSet.getString("MealCategory"),
                        resultSet.getInt("MealPrice"),
                        resultSet.getString("MealInfo"));


            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.getMessage();
            return null;
        }
    }


    public void create(Mealkit mealkit) {
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



    public List<Mealkit> findAll(){
        String selectSQL = "SELECT * FROM User";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            List<Mealkit> mealkits = new ArrayList<>();

            while(resultSet.next()){
                mealkits.add(
                        new Mealkit(
                                resultSet.getLong("id"),
                                resultSet.getString("MealName"),
                                resultSet.getString("MealCategory"),
                                resultSet.getInt("MealPrice"),
                                resultSet.getString("MealInfo")
                        )
                );
            }

            resultSet.close();
            return mealkits;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    };

    public Mealkit findbyCategory(String mealCategory){
        String selectSQL = "SELECT * FROM User WHERE MealCategory=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setString(1, mealCategory);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Mealkit(
                        resultSet.getLong("id"),
                        resultSet.getString("MealName"),
                        resultSet.getString("MealCategory"),
                        resultSet.getInt("MealPrice"),
                        resultSet.getString("MealInfo"));
            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    };



    public Mealkit findbyName(String mealName) {
        String selectSQL = "SELECT * FROM Mealkit WHERE MealName=?";

        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setString(1, mealName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Mealkit(
                        resultSet.getLong("id"),
                        resultSet.getString("MealName"),
                        resultSet.getString("MealCategory"),
                        resultSet.getInt("MealPrice"),
                        resultSet.getString("MealInfo")
                );
            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public Mealkit findbyPrice(int mealPrice) {
        String selectSQL = "SELECT * FROM Mealkit WHERE MealPrice=?";

        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setInt(1, mealPrice);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Mealkit(
                        resultSet.getLong("id"),
                        resultSet.getString("MealName"),
                        resultSet.getString("MealCategory"),
                        resultSet.getInt("MealPrice"),
                        resultSet.getString("MealInfo")
                );
            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void updateAll(Mealkit mealkit) {

        try {
            String updateSQL = "UPDATE Mealkit SET  MealName = ?, MealCategory = ?, MealPrice = ?, MealInfo = ? WHERE id = ?";

            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1, mealkit.getMealName());
            updateStatement.setString(2, mealkit.getMealCategory());
            updateStatement.setInt(3, mealkit.getMealPrice());
            updateStatement.setString(4, mealkit.getMealInfo());
            updateStatement.setLong(5, mealkit.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected >0) {
                System.out.println("업데이트되었습니다");
            } else {
                System.out.println("상품을 찾을 수 없습니다");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }


    public void updateName(Mealkit mealkit) {
        try {
            String updateSQL ="UPDATE Mealkit SET MealName =? WHERE MealID =? ";

            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1,mealkit.getMealName());
            updateStatement.setLong(2, mealkit.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected >0) {
                System.out.println("업데이트되었습니다");
            } else {
                System.out.println("상품을 찾을 수 없습니다");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    public void updateCategory(Mealkit mealkit){
        try {
            String updateSQL ="UPDATE Mealkit SET MealCategory =? WHERE MealID =? ";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1,mealkit.getMealCategory());
            updateStatement.setLong(2, mealkit.getMealID());

            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected >0){
                System.out.println("업데이트되었습니다");
            }else {
                System.out.println("상품을 찾을 수 없습니다");
            }
            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    public void updatePrice(Mealkit mealkit){
        try {
            String updateSQL ="UPDATE Mealkit SET MealPrice =? WHERE MealID =? ";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setInt(1,mealkit.getMealPrice());
            updateStatement.setLong(2, mealkit.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("상품 가격이 업데이트되었습니다.");
            } else {
                System.out.println("상품을 찾을 수 없습니다.");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    public void updateInfo(Mealkit mealkit) {
        try {
            String updateSQL ="UPDATE Mealkit SET MealCategory =? WHERE MealID =? ";

            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1,mealkit.getMealInfo());
            updateStatement.setLong(2, mealkit.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected >0) {
                System.out.println("업데이트되었습니다");
            } else {
                System.out.println("상품을 찾을 수 없습니다");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    public void delete(Long MealID){
        String selectSQL = "DELETE FROM User WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, MealID);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}