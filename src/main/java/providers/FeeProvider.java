package providers;

import db.DBConnection;
import model.Fee;

import javax.persistence.criteria.CriteriaBuilder;
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
                .replace("$IDD", (idSavingPlan!=-1)?""+ idSavingPlan:"" + idDebts)
                .replace("$TABLE", (idSavingPlan!=-1)?"saving_Plan":"debts")
                .replace("$IDNAME", (idSavingPlan!=-1)?"idSavingPlan":"idDebts");
        DBConnection connection = new DBConnection();
        return getAll(connection, sql);
    }

    public ArrayList<Fee> getAllSavingsFee(String email) throws SQLException, ParseException {
        String sql = ("SELECT fee.* FROM (fee INNER JOIN saving_plan ON fee.idSavingPlan = saving_plan.id) " +
                "INNER JOIN users ON users.id = saving_plan.idUSer WHERE users.email = $EMAIL AND fee.idDebts IS NULL").replace("$EMAIL", "'" + email + "'");
        DBConnection connection = new DBConnection();
        return getAll(connection, sql);
    }

    public double getAllSumSavingsFee(String email) throws SQLException, ParseException {
        String sql = ("SELECT SUM(fee.value) AS suma FROM (fee INNER JOIN saving_plan ON fee.idSavingPlan = saving_plan.id) " +
                "INNER JOIN users ON users.id = saving_plan.idUSer WHERE users.email = $EMAIL AND fee.idDebts IS NULL").replace("$EMAIL", "'" + email + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        double suma = -1;
        if(resultSet.next()) {
            suma = resultSet.getDouble(resultSet.findColumn("suma"));
        }
        return suma;
    }

    private ArrayList<Fee> getAll(DBConnection connection, String sql) throws SQLException, ParseException{
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        ArrayList<Fee> fees = new ArrayList<>();
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double value =Double.parseDouble(resultSet.getString(resultSet.findColumn("value")));
            String date = resultSet.getString(resultSet.findColumn("date"));
            String ids = resultSet.getString(resultSet.findColumn("idSavingPlan"));
            String idd = resultSet.getString(resultSet.findColumn("idDebts"));
            int idDebts = (idd!=null)?Integer.parseInt(idd):0;
            int idSavingPlan = (ids!=null)?Integer.parseInt(ids):0;
            fees.add(new Fee(id,value,DBConnection.format.parse(date), idSavingPlan, idDebts));
        }
        connection.disconnect();
        return fees;
    }

    public void updateTotalFee(int idSavingPlan) throws SQLException, ParseException {
        DBConnection connection = new DBConnection();

        double totalFee = getSumSavingFee(idSavingPlan);

        System.out.println(totalFee);

        String sql = ("UPDATE saving_plan SET totalFee=$VALUE WHERE id=$ID")
                .replace("$VALUE",totalFee+"")
                .replace("$ID", idSavingPlan+"");

        connection.connect();
        System.out.println(sql);
        connection.commandSQL(sql);
        connection.disconnect();
    }

    private double getSumSavingFee(int idSavingPlan) throws SQLException, ParseException{
        String sql = ("SELECT SUM(value) AS suma FROM fee WHERE idSavingPlan = $ID")
                .replace("$ID", "'" + idSavingPlan + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        double suma = -1;
        if(resultSet.next()) {
            suma= resultSet.getDouble(resultSet.findColumn("suma"));
        }
        return suma;
    }

    public double getSumDebtFee(int idDebts) throws SQLException, ParseException{
        String sql = ("SELECT SUM(value) AS suma FROM fee WHERE idDebts = $ID")
                .replace("$ID", "'" + idDebts + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        double sum = -1;
        if(resultSet.next()) {
            sum= resultSet.getDouble(resultSet.findColumn("suma"));
        }
        return sum;
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM fee WHERE id="+id;
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }
}