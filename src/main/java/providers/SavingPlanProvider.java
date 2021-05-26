package providers;

import db.DBConnection;
import model.SavingPlan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class SavingPlanProvider {
    public void addSavingPlan(SavingPlan savingPlan) throws SQLException {
        DBConnection connection = new DBConnection();
        String date =DBConnection.format.format(savingPlan.getDate());
        String sql = ("INSERT INTO saving_plan(goal, balance, total, date, monthlyFee, idUser) " +
                "VALUES ($GOAL,$BALANCE,$TOTAL, $DATE, $MONTHLYFEE, $IDUSER)")
                .replace("$GOAL","'"+savingPlan.getGoal()+"'")
                .replace("$BALANCE","'"+savingPlan.getBalance()+"'")
                .replace("$TOTAL", "'"+savingPlan.getTotal()+"'")
                .replace("$DATE","'"+ date+"'")
                .replace("$MONTHLYFEE","'"+savingPlan.getMonthlyFee()+"'")
                .replace("$IDUSER","'"+savingPlan.getIdUser()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public ArrayList<SavingPlan> getAllSavingPlans(int idUser) throws SQLException, ParseException {
        String sql = ("SELECT saving_plan.* FROM saving_plan INNER JOIN users ON saving_plan.idUser = users.id WHERE user.id = $ID")
                .replace("$ID", "'" + idUser + "'");
        DBConnection connection = new DBConnection();
        return getAllSavingPlans(sql,connection);
    }

    public ArrayList<SavingPlan> getAllSavingPlans(String userEmail) throws SQLException, ParseException {
        String sql = ("SELECT saving_plan.* FROM saving_plan INNER JOIN users ON saving_plan.idUser = users.id WHERE user.email = $EMAIl")
                .replace("$EMAIL", "'" + userEmail.trim() + "'");
        DBConnection connection = new DBConnection();
        return getAllSavingPlans(sql,connection);
    }

    private ArrayList<SavingPlan> getAllSavingPlans(String sql, DBConnection connection) throws SQLException, ParseException {
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        ArrayList<SavingPlan> savingPlans = null;
        while(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double goal =Double.parseDouble(resultSet.getString(resultSet.findColumn("goal")));
            double balance =Double.parseDouble(resultSet.getString(resultSet.findColumn("balance")));
            double total =Double.parseDouble(resultSet.getString(resultSet.findColumn("total")));
            String date = resultSet.getString(resultSet.findColumn("date"));
            int monthlyFee = Integer.parseInt(resultSet.getString(resultSet.findColumn("monthlyFee")));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            savingPlans.add(new SavingPlan(id,goal,balance,total,DBConnection.format.parse(date),monthlyFee,idUser));
        }
        connection.disconnect();
        return savingPlans;
    }
}
