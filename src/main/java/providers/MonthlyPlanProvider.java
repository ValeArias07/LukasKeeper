package providers;
import db.DBConnection;
import model.MonthlyPlan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class MonthlyPlanProvider{
    public void addMonthlyPlan(MonthlyPlan mp) throws SQLException {
        DBConnection connection = new DBConnection();
        String sql = ("INSERT INTO monthlyPlan(budget, hasAlert, spendingPercentage, idUser) " +
                "VALUES ($BUDGET,$HASALERT,$SP, $IDUS)")
                .replace("$BUDGET","'"+mp.getBudget()+"'")
                .replace("$HASALERT", "'" + ((mp.isHasAlert())?"true":"false") +"'")
                .replace("$SP","'"+mp.getSpendingPercentage()+"'")
                .replace("$IDUS","'"+ mp.getIdUser()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public MonthlyPlan getMonthlyPlan(String email) throws SQLException, ParseException {
        String sql = "SELECT monthlyPlan.* FROM monthlyPlan INNER JOIN users ON monthlyPlan.idUser = users.id WHERE users.email = $EMAIL".replace("$EMAIL", "'" + email.trim() + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        MonthlyPlan monthlyPlan = null;
        if(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double budget = Double.parseDouble(resultSet.getString(resultSet.findColumn("budget")));
            boolean hasAlert = Boolean.parseBoolean(resultSet.getString(resultSet.findColumn("hasAlert")));
            double spendingPercentage = Double.parseDouble(resultSet.getString(resultSet.findColumn("spendingPercentage")));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            monthlyPlan = new MonthlyPlan(id,budget,hasAlert,spendingPercentage,idUser);
        }
        return monthlyPlan;
    }
}
