package providers;

import db.DBConnection;
import model.ChangeInAsset;
import model.Debt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class ChangesInAssetsProvider {
    public void addChangeInAsset(ChangeInAsset change) throws SQLException {
        DBConnection connection = new DBConnection();
        String date =DBConnection.format.format(change.getDate());
        String sql = ("INSERT INTO changes_in_assets(value, description, date, frequency, idUserCategory, idDefaultCategory, idUser) " +
                "VALUES ($VALUE,$DESCRIPTION,$DATE, $FREQUENCY,$IDUCA,$IDDCA, $IDUS)")
                .replace("$VALUE","'"+change.getValue()+"'")
                .replace("$DESCRIPTION", "'"+change.getDescription()+"'")
                .replace("$DATE","'"+date+"'")
                .replace("$FREQUENCY","'"+change.getFrequency()+"'")
                .replace("$IDUCA", "'"+change.getIdUserCategory()+"'")
                .replace("$IDDCA", "'"+change.getIdDefaultCategory()+"'")
                .replace("$IDUS","'"+ change.getIdUser()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<ChangeInAsset> getAllExpenses(String email) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.email = $EMAIL AND changes_in_assets.value<0".replace("$EMAIL", "'" + email.trim() + "'");
        DBConnection connection = new DBConnection();
        return getAllChangesInAssets(sql, connection);
    }

    public ArrayList<ChangeInAsset> getAllExpenses(int userId) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.id = $IDUSER AND changes_in_assets.value<0".replace("$IDUSER", "'" + userId + "'");
        DBConnection connection = new DBConnection();
        return getAllChangesInAssets(sql, connection);
    }

    public ArrayList<ChangeInAsset> getAllIncomes(String email) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.email = $EMAIL AND changes_in_assets.value>=0".replace("$EMAIL", "'" + email.trim() + "'");
        DBConnection connection = new DBConnection();
        return getAllChangesInAssets(sql, connection);
    }

    public ArrayList<ChangeInAsset> getAllIncomes(int userId) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.id = $IDUSER AND changes_in_assets.value>=0".replace("$IDUSER", "'" + userId + "'");
        DBConnection connection = new DBConnection();
        return getAllChangesInAssets(sql, connection);
    }

    public ArrayList<ChangeInAsset> getAllMonthExpenses(String email, String yearMonth) throws SQLException, ParseException {
        String sql = ("SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE changes_in_assets.date LIKE $DATE AND users.email ="+"'"+email+"'"+"AND changes_in_assets.value<0")
                .replace("$DATE", "'" + yearMonth + "-%'")
                .replace("$EMAIL", "'" + email+ "'");
        DBConnection connection = new DBConnection();
        return getAllChangesInAssets(sql,connection);
    }

    public ArrayList<ChangeInAsset> getAllMonthIncomes(String email, String yearMonth) throws SQLException, ParseException {
        String sql = ("SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE changes_in_assets.date LIKE $DATE AND users.email = "+"'"+email+"'"+" AND changes_in_assets.value>=0")
                .replace("$EMAIl", "'" + email +"'")
                .replace("$DATE", "'" + yearMonth + "-%'");
        DBConnection connection = new DBConnection();
        return getAllChangesInAssets(sql,connection);
    }

    private ArrayList<ChangeInAsset> getAllChangesInAssets(String sql, DBConnection connection) throws SQLException, ParseException {
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        ArrayList<ChangeInAsset> changesInAssets = new  ArrayList<ChangeInAsset>();
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double value =Double.parseDouble(resultSet.getString(resultSet.findColumn("value")));
            String description = resultSet.getString(resultSet.findColumn("description"));
            String date = resultSet.getString(resultSet.findColumn("date"));
            String frequency = resultSet.getString(resultSet.findColumn("frequency"));
            int idUserCategory = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUserCategory")));
            int idDefaultCategory = Integer.parseInt(resultSet.getString(resultSet.findColumn("idDefaultCategory")));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            changesInAssets.add(new ChangeInAsset(id,value,description,DBConnection.format.parse(date), frequency, idUserCategory, idDefaultCategory, idUser));
        }
        connection.disconnect();
        return changesInAssets;
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM changes_in_assets WHERE id ="+id;
        DBConnection connection =  new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }
}
