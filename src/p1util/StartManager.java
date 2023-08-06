package p1util;

import p7quart.HashCoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StartManager {

    private static final String CHECK_HAVE_SQL = """
            SELECT EXISTS (SELECT id FROM console_user);
            """;
    private static final String ACTIVATION_SQL = """
            CREATE TABLE console_user (
                id SERIAL PRIMARY KEY,
                user_name VARCHAR(30) NOT NULL UNIQUE ,
                hash_pass INT NOT NULL,
                master BOOLEAN NOT NULL
            );
                        
            insert into console_user (user_name, hash_pass, master) values
            ('master', ?, true);
                        
            CREATE TABLE console_button (
                button VARCHAR(32) PRIMARY KEY,
                user_id int REFERENCES console_user,
                user_button VARCHAR(10) ,
                UNIQUE (user_id, user_button)
            )
            """;

    public static void activateTables() {
        try (Connection connection = ConnectorManager.getConnection();
             PreparedStatement activationCheck = connection.prepareStatement(CHECK_HAVE_SQL);
             PreparedStatement activationTables = connection.prepareStatement(ACTIVATION_SQL)) {

            if(!activationCheck.execute()) {
                activationTables.setInt(1, HashCoder.getHash("master"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
