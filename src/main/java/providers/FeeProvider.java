package providers;

import db.DBConnection;
import model.Fee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class FeeProvider {
    public void addFee(Fee fee) throws SQLException {
        DBConnection connection = new DBConnection();
        String date =DBConnection.format.format(fee.getDate());
        String sql = ("INSERT INTO fee(value, date, idSavingPlan, idDebts) " +
                "VALUES ($VALUE,$DATE,$IDSP, $IDD)")
                .replace("$VALUE","'"+fee.getValue()+"'")
                .replace("$DATE","'"+date+"'")
                .replace("$IDSP", (fee.getIdSavingPlan()!=0)?"'"+fee.getIdSavingPlan()+"'":"NULL")
                .replace("$IDD",(fee.getIdDebts()!=0)?"'"+ fee.getIdDebts()+"'":"NULL");
        connection.connect();
        System.out.println(sql);
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<Fee> getAllFee(int idSavingPlan, int idDebts) throws SQLException, ParseException {
        String sql = ("SELECT fee.* FROM fee INNER JOIN $TABLE ON fee.$IDNAME = $TABLE.id WHERE $TABLE.id = $IDD")
                .replace("$IDD", (idSavingPlan!=-1)?"'" + idSavingPlan + "'":"'" + idDebts + "'")
                .replace("$TABLE", (idSavingPlan!=-1)?"'savingPlan'":"'debts'")
                .replace("$IDNAME", (idSavingPlan!=-1)?"'idSavingPlan'":"'idDebts'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        ArrayList<Fee> fees = null;
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double value =Double.parseDouble(resultSet.getString(resultSet.findColumn("value")));
            String date = resultSet.getString(resultSet.findColumn("date"));
            fees.add(new Fee(id,value,DBConnection.format.parse(date), idSavingPlan, idDebts));
        }
        connection.disconnect();
        return fees;
    }
}