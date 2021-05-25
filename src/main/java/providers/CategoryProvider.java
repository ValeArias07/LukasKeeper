package providers;

import db.DBConnection;
import model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class CategoryProvider {
    public void addCategory(Category category) throws SQLException {
        DBConnection connection = new DBConnection();
        String sql = ("INSERT INTO user_categories(name, type, idUser) " +
                "VALUES ($NAME,$TYPE,$ID)")
                .replace("$NAME","'"+category.getName()+"'")
                .replace("$TYPE", "'"+category.getType()+"'")
                .replace("$ID", "'"+category.getIdUser()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Category> getAllCategory(int idUser) throws SQLException {
        String sql = "SELECT user_categories.* FROM user_categories INNER JOIN users ON user_categories.idUser = users.id WHERE users.id = $ID".replace("$ID","'" + idUser + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        ArrayList<Category> categories = getAllDefaultCategories();
        return getAllCategory(resultSet,categories);
    }

    public ArrayList<Category> getAllCategory(String email) throws SQLException {
        String sql = "SELECT user_categories.* FROM user_categories INNER JOIN users ON user_categories.idUser = users.id WHERE users.email = $EMAIl".replace("$EMAIL","'" + email + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        ArrayList<Category> categories = getAllDefaultCategories();
        return getAllCategory(resultSet,categories);
    }

    private ArrayList<Category> getAllDefaultCategories()throws SQLException{
        String sql = "SELECT * FROM default_categories WHERE 1 ";
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        return getAllCategory(resultSet,null);
    }

    private ArrayList<Category> getAllCategory(ResultSet resultSet, ArrayList<Category> categories) throws SQLException {
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            String name = resultSet.getString(resultSet.findColumn("name"));
            String type = resultSet.getString(resultSet.findColumn("type"));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            categories.add(new Category(id,name,type,idUser));
        }
        return categories;
    }
}
