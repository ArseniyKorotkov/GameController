package p3dao;

import p1util.ConnectorManager;
import p2entity.Role;
import p2entity.User;
import p7quart.HashCoder;

import java.sql.*;
import java.util.Optional;

public final class UserDao {

    private static final UserDao userDao = new UserDao();

    private UserDao() {
    }

    private static final String CHECK_USER_SQL = """
            SELECT *
            FROM console_user
            WHERE user_name = ? AND hash_pass = ?
            """;

    private static final String CHECK_NAME_SQL = """
            SELECT id
            FROM console_user
            WHERE user_name = ?
            """;

    public Optional<User> findUser(String name, String pass) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatementUser = connection.prepareStatement(CHECK_USER_SQL)) {

            preparedStatementUser.setString(1, name);
            preparedStatementUser.setInt(2, HashCoder.getHash(pass));

            ResultSet resultSetUser = preparedStatementUser.executeQuery();

            return buildUser(resultSetUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public boolean findName(String name) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatementName = connection.prepareStatement(CHECK_NAME_SQL)) {

            preparedStatementName.setString(1, name);

            ResultSet resultSetName = preparedStatementName.executeQuery();

            return resultSetName.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    private Optional<User> buildUser(ResultSet result) throws SQLException {
        Optional<User> user = Optional.empty();
        Role role = Role.VISITOR;

        if (result.next()) {
            if(result.getBoolean(4)) {
                role = Role.MASTER;
            }
            user = Optional.of(new User(
                    result.getInt(1),
                    result.getString(2),
                    role));
        }
        return user;
    }

    public static UserDao getInstance() {
        return userDao;
    }
}
