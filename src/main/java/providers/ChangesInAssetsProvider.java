package providers;

import db.DBConnection;
import model.ChangeInAsset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class ChangesInAssetsProvider {
    public void addChangeInAsset(ChangeInAsset change) throws SQLException {
        DBConnection connection = new DBConnection();
        String date =DBConnection.format.format(change.getDate());
        String sql = ("INSERT INTO changes_in_assets(value, description, date, frequency, idCategory, idUser) " +
                "VALUES ($VALUE,$DESCRIPTION,$DATE, $FREQUENCY,$IDCA, $IDUS)")
                .replace("$VALUE","'"+change.getValue()+"'")
                .replace("$DESCRIPTION", "'"+change.getDescription()+"'")
                .replace("$DATE","'"+date+"'")
                .replace("$FREQUENCY","'"+change.getFrequency()+"'")
                .replace("$IDCA", "'"+change.getIdCategory()+"'")
                .replace("$IDUS","'"+ change.getIdUser()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<ChangeInAsset> getAllExpenses(String email) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.email = $EMAIL AND changes_in_assets.value<0".replace("$EMAIL", "'" + email.trim() + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        return getAllChangesInAssets(resultSet);
    }

    public ArrayList<ChangeInAsset> getAllExpenses(int userId) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.id = $IDUSER AND changes_in_assets.value<0".replace("$IDUSER", "'" + userId + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        return getAllChangesInAssets(resultSet);
    }

    public ArrayList<ChangeInAsset> getAllIncomes(String email) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.email = $EMAIL AND changes_in_assets.value>=0".replace("$EMAIL", "'" + email.trim() + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        return getAllChangesInAssets(resultSet);
    }

    public ArrayList<ChangeInAsset> getAllIncomes(int userId) throws SQLException, ParseException {
        String sql = "SELECT changes_in_assets.* FROM changes_in_assets INNER JOIN users ON changes_in_assets.idUser = users.id WHERE users.id = $IDUSER AND changes_in_assets.value>=0".replace("$IDUSER", "'" + userId + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        return getAllChangesInAssets(resultSet);
    }

    private ArrayList<ChangeInAsset> getAllChangesInAssets(ResultSet resultSet) throws SQLException, ParseException {
        ArrayList<ChangeInAsset> changesInAssets = null;
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double value =Double.parseDouble(resultSet.getString(resultSet.findColumn("value")));
            String description = resultSet.getString(resultSet.findColumn("description"));
            String date = resultSet.getString(resultSet.findColumn("date"));
            String frequency = resultSet.getString(resultSet.findColumn("frequency"));
            int idCategory = Integer.parseInt(resultSet.getString(resultSet.findColumn("idCategory")));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            changesInAssets.add(new ChangeInAsset(id,value,description,DBConnection.format.parse(date), frequency, idCategory, idUser));
        }
        return changesInAssets;
    }
}