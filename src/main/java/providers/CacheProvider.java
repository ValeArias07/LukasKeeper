package providers;

import db.DBConnection;
import model.Cache;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class CacheProvider {
    public void addCache(Cache cache) throws SQLException {
        DBConnection connection = new DBConnection();
        String sql = ("INSERT INTO user_cache(monthlyBalance, savingBalance, expendingBalance, debtsBalance, idUser) " +
                "VALUES ($MB,$SB,$EB, $DB,$IDUSER)")
                .replace("$MB","'"+cache.getMonthlyBalance()+"'")
                .replace("$SB", "'"+cache.getSavingBalance()+"'")
                .replace("$EB","'"+cache.getExpendingBalance()+"'")
                .replace("$DB","'"+cache.getDebtsBalance()+"'")
                .replace("$IDUSER", "'"+cache.getIdUser()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public void updateCache(Cache cache) throws SQLException {
        DBConnection connection = new DBConnection();
        String sql = ("UPDATE user_cache SET monthlyBalance=$MB, savingBalance=$SB, expendingBalance=$EB, debtsBalance=$DB, idUser=$IDUSER WHERE id=$ID")
                .replace("$ID","'" + cache.getId() + "'")
                .replace("$MB","'"+cache.getMonthlyBalance()+"'")
                .replace("$SB", "'"+cache.getSavingBalance()+"'")
                .replace("$EB","'"+cache.getExpendingBalance()+"'")
                .replace("$DB","'"+cache.getDebtsBalance()+"'")
                .replace("$IDUSER", "'"+cache.getIdUser()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    private Cache getCache(int idUser) throws SQLException, ParseException {
        String sql = "SELECT user_cache.* FROM user_cache INNER JOIN users ON user_cache.idUser = users.id WHERE users.id = $ID".replace("$ID", "'" + idUser + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        Cache cache = null;
        if(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double monthlyBalance = Double.parseDouble(resultSet.getString(resultSet.findColumn("monthlyBalance")));
            double savingBalance = Double.parseDouble(resultSet.getString(resultSet.findColumn("savingBalance")));
            double expendingBalance = Double.parseDouble(resultSet.getString(resultSet.findColumn("expendingBalance")));
            double debtsBalance = Double.parseDouble(resultSet.getString(resultSet.findColumn("debtsBalance")));
            double incomeBalance = Double.parseDouble(resultSet.getString(resultSet.findColumn("incomeBalance")));
            cache = new Cache(id, monthlyBalance, savingBalance, expendingBalance, debtsBalance, idUser, incomeBalance);
        }
        connection.disconnect();
        return cache;
    }
}
