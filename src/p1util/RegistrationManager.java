package p1util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class RegistrationManager {

    private RegistrationManager(){
    }

    private static final String SQL_REGISTRATION = """
            INSERT INTO console_user (password, user_name) VALUES (?, ?);
            """;

    public static void registration(String name, String password) {

        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REGISTRATION)) {
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
