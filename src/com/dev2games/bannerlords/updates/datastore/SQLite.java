/**
 * This file is part of bannerlords-updates.
 * <p>
 * bannerlords-updates is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * bannerlords-updates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with bannerlords-updates.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.dev2games.bannerlords.updates.datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Handles our SQLite database
 * @author Nelson Sanchez
 *
 */

public class SQLite {

    private Connection connection;
    private String databaseName;

    public SQLite(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * Creates a connection to the SQLite database
     */

    public void connect() {
        try {
            String url = "jdbc:sqlite:C:/Users/Nelson/Desktop/" + this.databaseName + ".sqlite";
            connection = DriverManager.getConnection(url);
            System.out.println("Successfully connected to SQLite database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the connection to the SQLite database
     */

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Inserts a new row into the SQLite database
     * @param threadId the thread id on the forum
     * @param title the title of the forum thread
     * @param author the author of the post
     * @param content the content in the thread
     * @param avatar the avatar url of the user who posted
     * @param date the date of which it was posted
     */

    public void insert(int threadId, String title, String author, String content, String avatar, String date) {
        String query = "INSERT INTO threads(thread_id, title, author, content, avatar_url, date) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, threadId);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.setString(4, content);
            statement.setString(5, avatar);
            statement.setString(6, date);
            statement.executeUpdate();
            System.out.println("Successfully inserted dummy data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
