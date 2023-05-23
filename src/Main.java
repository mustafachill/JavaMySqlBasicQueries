import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Selection();
        Insert();
        Update();
        Delete();
    }

    public static void Selection() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select actor_id,first_name,last_name,last_update from sakila.actor");
            ArrayList<Actor> actors = new ArrayList<Actor>();
            while (resultSet.next()) {
                actors.add(new Actor(
                        resultSet.getString("actor_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("last_update")));
            }

            for (Actor actor : actors) {
                System.out.println(actor);
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }

    public static void Insert() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "insert into sakila.actor (first_name,last_name,last_update) values (?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, "Mustafa");
            statement.setObject(2, "Çil");
            statement.setObject(3, "2004-04-14 05:30:00");
            statement.executeUpdate();
            System.out.println("kayıt eklendi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void Update() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "update sakila.actor set first_name='mustafa' where actor_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 207);
            statement.executeUpdate();
            System.out.println("kayıt güncellendi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void Delete() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            String sql = "delete from sakila.actor where actor_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 207);
            statement.executeUpdate();
            System.out.println("kayıt silindi");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }
}