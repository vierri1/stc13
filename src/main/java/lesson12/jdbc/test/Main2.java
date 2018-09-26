package lesson12.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile", "postgres", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  mobile set price=5000 where id = ?");
        for (String arg : args) {
            preparedStatement.setInt(1, Integer.parseInt(arg));
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        connection.close();

    }
}
