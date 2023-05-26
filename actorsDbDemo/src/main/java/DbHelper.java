
import java.sql.*;

public class DbHelper {
    private String username="root";
    private String password="şifre";
    private String dbUrl="jdbc:mysql://localhost:3306/sakila.actor";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,username,password);
    }
    public void ShowErrorMessage(SQLException exception){
        System.out.println("Error :" +exception.getMessage());
        System.out.println("ErrorCode :" +exception.getErrorCode());
}

    void showErrorMessage(SQLException exception) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

