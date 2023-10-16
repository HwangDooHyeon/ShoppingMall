package DAO;

import OBJ.Mealkit;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MealkitDAOImplement implements MealkitDAO {

    private static MealkitDAOImplement instance = new MealkitDAOImplement();

    private MealkitDAOImplement(){}

    public static MealkitDAOImplement getInstance() {return instance;}

    private Connection connection = null;


    public void createTable() {

    }

    public void create(){};

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
                                resultSet.getString("MealPrice"),
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
                        resultSet.getString("MealPrice"),
                        resultSet.getString("MealInfo"));
            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    };

    public void findbyName(){};

    public void findbyPrice(){};

    public void updateMealkit(){

    };

    public void delete(){};

}
