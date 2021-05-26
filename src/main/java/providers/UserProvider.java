package providers;

import db.DBConnection;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class UserProvider {
    public void addUser(User user) throws SQLException {
       DBConnection connection = new DBConnection();
       String date =DBConnection.format.format(user.getDateOfBirth());
       System.out.println(user.getLastName());
       String sql = ("INSERT INTO users(name, lastname, email, password, dateOfbirth, bank, occupation) " +
                "VALUES ($NAME,$LASTNAME,$EMAIL, $PASSWORD,$BORNDATE, $BANK,$OCCUPATION)")
                .replace("$NAME","'"+user.getName()+"'")
                .replace("$LASTNAME", "'"+user.getLastName()+"'")
                .replace("$EMAIL","'"+user.getEmail()+"'")
                .replace("$PASSWORD","'"+user.getPassword()+"'")
                .replace("$BORNDATE", "'"+date+"'")
                .replace("$BANK","'"+ user.getBank()+"'")
                .replace("$OCCUPATION", "'"+user.getOccupation()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public void updateUser(User user) throws SQLException {
        DBConnection connection = new DBConnection();
        String date =DBConnection.format.format(user.getDateOfBirth());
        System.out.println(user.getLastName());
        String sql = ("UPDATE users SET name=$NAME, lastname=$LASTNAME, email=$EMAIL, password=$PASSWORD, dateOfbirth=$BORNDATE, bank=$BANK, occupation=$OCCUPATION WHERE email=$EMAIL")
                .replace("$NAME","'"+user.getName()+"'")
                .replace("$LASTNAME", "'"+user.getLastName()+"'")
                .replace("$EMAIL","'"+user.getEmail()+"'")
                .replace("$PASSWORD","'"+user.getPassword()+"'")
                .replace("$BORNDATE", "'"+date+"'")
                .replace("$BANK","'"+ user.getBank()+"'")
                .replace("$OCCUPATION", "'"+user.getOccupation()+"'");
        connection.connect();
        connection.commandSQL(sql);
        connection.disconnect();
    }

    public User getUser(String email) throws SQLException, ParseException {
        String sql = "SELECT * FROM users WHERE email = $EMAIL".replace("$EMAIL", "'" + email.trim() + "'");
        DBConnection connection = new DBConnection();

        return getUser(sql,connection);
    }

    public User getUser(int UserId) throws SQLException, ParseException {
        String sql = "SELECT * FROM users WHERE id = $ID".replace("$ID", "'" + UserId + "'");
        DBConnection connection = new DBConnection();

        return  getUser(sql,connection);
    }

    private User getUser(String sql, DBConnection connection) throws SQLException, ParseException{
        connection.connect();
        ResultSet resultSet =  connection.getDataBySQL(sql);
        connection.disconnect();
        User user = null;
        if(resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(resultSet.findColumn("id")));
            String name = resultSet.getString(resultSet.findColumn("name"));
            String lastName = resultSet.getString(resultSet.findColumn("lastname"));
            String password = resultSet.getString(resultSet.findColumn("password"));
            String dateOfBirth = resultSet.getString(resultSet.findColumn("dateOfbirth"));
            String email =  resultSet.getString(resultSet.findColumn("email"));
            String bank = resultSet.getString(resultSet.findColumn("bank"));
            String occupation = resultSet.getString(resultSet.findColumn("occupation"));
            user = new User(id, name, lastName, dateOfBirth, email, password, bank, occupation);
        }
        return user;
    }
}
