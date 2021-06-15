package providers;

import db.DBConnection;
import model.Cache;
import model.Debt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class CacheProvider {
    public void addCache(Cache cache) throws SQLException {
        DBConnection connection = new DBConnection();
        String sql = ("INSERT INTO user_cache(incomeBalance, monthlyBalance, savingBalance, expendingBalance, debtsBalance, idUser) " +
                "VALUES ($IB, $MB,$SB,$EB, $DB,$IDUSER)")
                .replace("$IB", "'" + cache.getIncomeBalance()+"'")
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
        String sql = ("UPDATE user_cache SET incomeBalance=$IB, monthlyBalance=$MB, savingBalance=$SB, expendingBalance=$EB, debtsBalance=$DB, " +
                "idUser=$IDUSER WHERE id=$ID")
                .replace("$ID","'" + cache.getId() + "'")
                .replace("$IB", "'"+cache.getIncomeBalance()+"'")
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

    /**
     *
     * @param debt Registro de la tabla que se va a modificar
     * @param isAdd Valida si se agrega un debt o se elimina del cache
     */
    public void updateDebtCache(Debt debt, boolean isAdd) throws SQLException {
        String fetchQuery = "SELECT user_cache.* FROM user_cache WHERE idUser = $ID"
                .replace("$ID", "'" + debt.getIdUser() + "'");
        DBConnection connection = new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(fetchQuery);
        double newDebt = 0;
        if(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            double debtsBalance = Double.parseDouble(resultSet.getString(resultSet.findColumn("debtsBalance")));

            if(isAdd) {
                newDebt = debtsBalance + debt.getValue();
            } else {
                newDebt = debtsBalance - debt.getValue();
            }

            String sql = ("UPDATE user_cache SET debtsBalance=$DB WHERE id=$ID")
                    .replace("$ID","'" + id + "'")
                    .replace("$DB","'"+newDebt+"'");
        }
        connection.disconnect();
    }
}
