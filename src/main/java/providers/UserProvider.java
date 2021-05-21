package providers;

import db.DBConnection;
import model.User;

import java.sql.SQLException;

public class UserProvider {

    public void addUser(User user){
        try {

            DBConnection connection = new DBConnection();
           String date =User.format.format(user.getDateOfBirth());
           System.out.print(User.format.format(user.getDateOfBirth()));
           String sql = ("INSERT INTO users(name, lastname, email, password, dateOfbirth, bank, occupation) " +
                    "VALUES ($NAME,$LASTNAME,$EMAIL, $PASSWORD,$BORNDATE, $BANK,$OCCUPATION")
                    .replace("$NAME","'"+user.getName()+"'")
                    .replace("$LASTNAME", "'"+user.getLastName()+"'")
                    .replace("$EMAIL","'"+ user.getEmail()+"'")
                    .replace("$PASSWORD","'"+ user.getPassword()+"'")
                    .replace("$BORNDATE", "'" + date + "'")
                    .replace("$BANK","'"+ user.getBank()+"'")
                    .replace("$OCCUPATION", "'"+user.getOccupation()+"'");
            connection.commandSQL(sql);
            connection.disconnect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
