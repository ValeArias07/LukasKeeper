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
        String sql = ("INSERT INTO saving_plan(goal, description, totalFee, date, monthlyFee, idUser) " +
                "VALUES ($GOAL,$DESCRIPTION,$TOTAL, $DATE, $MONTHLYFEE, $IDUSER)")
                .replace("$GOAL","'"+savingPlan.getGoal()+"'")
                .replace("$DESCRIPTION", "'"+savingPlan.getDescription()+"'")
                .replace("$TOTAL", "'"+savingPlan.getTotalFee()+"'")
                .replace("$DATE","'"+ savingPlan.getDate()+"'")
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
            String description =resultSet.getString(resultSet.findColumn("description"));
            double total =Double.parseDouble(resultSet.getString(resultSet.findColumn("totalFee")));
            String date = resultSet.getString(resultSet.findColumn("date"));
            int monthlyFee = Integer.parseInt(resultSet.getString(resultSet.findColumn("monthlyFee")));
            int idUser = Integer.parseInt(resultSet.getString(resultSet.findColumn("idUser")));
            savingPlans.add(new SavingPlan(id,goal,description,total,date,monthlyFee,idUser));
        }
        connection.disconnect();
        return savingPlans;
    }

    public ArrayList<SavingPlan> getAllSavingPlansNames(String userEmail) throws SQLException, ParseException {
        String sql = ("SELECT saving_plan.* FROM saving_plan INNER JOIN users ON saving_plan.idUser = users.id WHERE users.email = "+"'"+userEmail+"'");
        DBConnection connection = new DBConnection();
        return getAllSavingPlansNames(sql,connection);
    }

    private ArrayList<SavingPlan> getAllSavingPlansNames(String sql, DBConnection connection) throws SQLException, ParseException {
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        ArrayList<SavingPlan> savingPlans= new ArrayList<SavingPlan>();
        while(resultSet.next()) {
            String description =resultSet.getString(resultSet.findColumn("description"));
            savingPlans.add(new SavingPlan(description));
        }
        connection.disconnect();
        return savingPlans;
    }
}
