package providers;

import db.DBConnection;
import model.User;

import java.sql.SQLException;

public class UserProvider {

    public void addUser(User user){
        try {
            DBConnection connection = new DBConnection();
            connection.connect();
            String sql = ("INSERT INTO users(name, lastname, email, password, dateOfbirth, bank, occupation, idMonthlyPlan, idCache) " +
                    "VALUES ($NAME,$LASTNAME,$EMAIL, $PASSWORD,$BORNDATE, $BANK,$OCCUPATION, $IDMONTHLYPLAN, $IDCACHE)")
                    .replace("$NAME","'"+user.getName()+"'")
                    .replace("$LASTNAME", "'"+user.getLastName()+"'")
                    .replace("$EMAIL","'"+ user.getEmail()+"'")
                    .replace("$PASSWORD","'"+ user.getPassword()+"'")
                    .replace("$BORNDATE", "'" + User.format.format(user.getDateOfBirth()) + "'")
                    .replace("$BANK","'"+ user.getBank()+"'")
                    .replace("$OCCUPATION", "'"+user.getOccupation()+"'");
            connection.commandSQL(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
