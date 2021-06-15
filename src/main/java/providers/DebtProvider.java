package providers;

import db.DBConnection;
import model.Debt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class DebtProvider {
    public void addDebt(Debt debt) throws SQLException {
        DBConnection connection = new DBConnection();
        String date =DBConnection.format.format(debt.getDate());
        String sql = ("INSERT INTO debts(value, description, date, fee, interest, idUser) " +
                "VALUES ($VALUE,$DESCRIPTION,$DATE, $FEE,$INTEREST,$IDUSER)")
                .replace("$VALUE",""+debt.getValue()+"")
                .replace("$DESCRIPTION", "'"+debt.getDescription()+"'")
                .replace("$DATE","'"+date+"'")
                .replace("$FEE",""+debt.getFee()+"")
                .replace("$INTEREST", ""+debt.getInterest()+"")
                .replace("$IDUSER",""+ debt.getIdUser());
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Debt> getAllDebts(int idUser) throws SQLException, ParseException {
        String sql = ("SELECT debts.* FROM debts INNER JOIN users ON debts.idUser = users.id WHERE users.id = $IDUSER").replace("$IDUSER", "'" + idUser + "'");
        DBConnection connection = new DBConnection();
        return getAllDebts(sql,connection);
    }

    public ArrayList<Debt> getAllDebts(String emailUser) throws SQLException, ParseException {
        String sql = ("SELECT debts.* FROM debts INNER JOIN users ON debts.idUser = users.id WHERE users.email = $EMAIL").replace("$EMAIL", "'" + emailUser.trim() + "'");
        DBConnection connection = new DBConnection();
        return getAllDebts(sql,connection);
    }

    public ArrayList<Debt> getAllMonthDebts(String email, String yearMonth) throws SQLException, ParseException {
        String sql = ("SELECT debts.* FROM debts INNER JOIN users ON debts.idUser = users.id WHERE debts.date LIKE %DATE AND users.email ="+"'"+email+"'")
                .replace("$EMAIL", "'" + email.trim() + "'")
                .replace("%DATE", "'" + yearMonth + "-%'");
        DBConnection connection = new DBConnection();
        return getAllDebts(sql,connection);
    }

    private ArrayList<Debt> getAllDebts(String sql, DBConnection connection) throws SQLException, ParseException {
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        ArrayList<Debt> debts = new ArrayList<Debt>();
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double value = Double.parseDouble(resultSet.getString(resultSet.findColumn("value")));
            String description = resultSet.getString(resultSet.findColumn("description"));
            String date = resultSet.getString(resultSet.findColumn("date"));
            int fee = Integer.parseInt(resultSet.getString(resultSet.findColumn("fee")));
            double interest = Double.parseDouble(resultSet.getString(resultSet.findColumn("interest")));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            debts.add(new Debt(id,value,description,(DBConnection.format.parse(date)),fee,interest,idUser));
        }
        connection.disconnect();
        return debts;
    }


    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM debts WHERE id ="+id;
        DBConnection connection =  new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public Debt getDebt(int id) throws SQLException, ParseException {
        String sql = "SELECT * FROM debts WHERE id ="+id;
        Debt debt = null;
        DBConnection connection =  new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        if (resultSet.next()) {
            double value = Double.parseDouble(resultSet.getString(resultSet.findColumn("value")));
            String description = resultSet.getString(resultSet.findColumn("description"));
            String date = resultSet.getString(resultSet.findColumn("date"));
            int fee = Integer.parseInt(resultSet.getString(resultSet.findColumn("fee")));
            double interest = Double.parseDouble(resultSet.getString(resultSet.findColumn("interest")));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            debt = new Debt(value,description,(DBConnection.format.parse(date)),fee,interest,idUser);
        }
        return debt;
    }
}
