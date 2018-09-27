package lesson12.jdbc.realExamle.dao;

import lesson12.jdbc.realExamle.ConnectionManager.ConnectionManager;
import lesson12.jdbc.realExamle.ConnectionManager.ConnectionManagerJdbcImpl;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDaoTest {
    @BeforeEach
    void setUp() {
        ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM mobile;\n" +
                             "DELETE FROM manufacturer;\n" +
                             "\n" +
                             "ALTER SEQUENCE manufacturer_id_seq RESTART WITH 1;\n" +
                             "ALTER SEQUENCE mobile_id_seq RESTART WITH 1;\n" +
                             "\n" +
                             "INSERT INTO manufacturer (name, country) VALUES\n" +
                             "  ('Siemens', 'Germany'),\n" +
                             "  ('Apple', 'USA'),\n" +
                             "  ('Motorola', 'USA'),\n" +
                             "  ('Nokia', 'Finland');\n" +
                             "\n" +
                             "INSERT INTO mobile (model, price, manufacturer_id) VALUES\n" +
                             "  ('c35', 5000, 1),\n" +
                             "  ('3310', 2000, 4),\n" +
                             "  ('5110', 5000, 4),\n" +
                             "  ('3G', 12000, 2),\n" +
                             "  ('c25', 3000, 1),\n" +
                             "  ('Milestone', 1500, 3);")) {
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
