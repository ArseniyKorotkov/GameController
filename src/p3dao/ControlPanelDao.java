package p3dao;

import p1util.ConnectorManager;
import p2entity.ControlButton;
import p2entity.KeyboardButtonEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ControlPanelDao {

    private static final ControlPanelDao CONTROL_PANEL_DAO = new ControlPanelDao();

    private static final String GET_BUTTON_VALUE_SQL = """
            SELECT button, user_id, user_button
            FROM console_button
            WHERE user_id = ? AND user_button = ?;
            """;

    private static final String SET_BUTTON_VALUE_SQL = """
            UPDATE console_button
            SET user_id = ?, user_button=?
            WHERE button like ?
            """;

    private static final String GET_KEY_USER_ID_SQL = """
            SELECT user_id
            FROM console_button
            WHERE button= ?;
            """;

    private static final String GET_All_BUTTONS_VALUE_SQL = """
            SELECT button, user_id, user_button
            FROM console_button
            """;

    private static final String DELETE_BUTTON_VALUE_SQL = """
            UPDATE console_button
            SET user_id = NULL, user_button= NULL
            WHERE button like ?
            """;


    private ControlPanelDao() {
    }

    public Optional<KeyboardButtonEntity> getButtonValue(Integer userId, ControlButton controlButton) {
        Optional<KeyboardButtonEntity> value = Optional.empty();
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BUTTON_VALUE_SQL)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, controlButton.name());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                value = Optional.of((keyBuilder(resultSet)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }


    public Optional<Integer> getKeyUserId(String keyboardButtonName) {
        Optional<Integer> keyUserId = Optional.empty();
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_KEY_USER_ID_SQL)) {

            preparedStatement.setString(1, keyboardButtonName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                keyUserId = Optional.of(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keyUserId;
    }


    public void setButtonValue(KeyboardButtonEntity keyboardButton) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SET_BUTTON_VALUE_SQL)) {

            System.out.println(keyboardButton.getUserId().get());   /****/
            System.out.println(keyboardButton.name());      /*****/
            System.out.println(keyboardButton.getControlButton().get().name()); /****/
            System.out.println("----");                             /*****/
            preparedStatement.setInt(1, keyboardButton.getUserId().get());
            preparedStatement.setString(2, keyboardButton.getControlButton().get().name());
            preparedStatement.setString(3, keyboardButton.name());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteButtonValue(String keyboardButtonName) {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BUTTON_VALUE_SQL)) {

            preparedStatement.setString(1, keyboardButtonName);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KeyboardButtonEntity> getAllButtonsValue() {
        ArrayList<KeyboardButtonEntity> values = new ArrayList<>();
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_All_BUTTONS_VALUE_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                values.add(keyBuilder(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }




    private KeyboardButtonEntity keyBuilder(ResultSet resultSet) throws SQLException {
        return KeyboardButtonEntity.build(
                resultSet.getString(1),
                resultSet.getInt(2),
                resultSet.getString(3)
        );
    }


    public static ControlPanelDao getInstance() {
        return CONTROL_PANEL_DAO;
    }

}


