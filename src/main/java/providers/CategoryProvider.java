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
        String sql = ("INSERT INTO category(name, type) " +
                "VALUES ($NAME,$TYPE)")
                .replace("$NAME","'"+category.getName()+"'")
                .replace("$TYPE", "'"+category.getType()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Category> getAllCategory() throws SQLException, ParseException {
        String sql = "SELECT * FROM category WHERE 1 ";
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        ArrayList<Category> categories = null;
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            String name = resultSet.getString(resultSet.findColumn("name"));
            String type = resultSet.getString(resultSet.findColumn("type"));
            categories.add(new Category(id,name,type));
        }
        return categories;
    }
}
