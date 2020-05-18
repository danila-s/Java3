package chat.server.core;

import java.sql.*;

public class SqlClient {

    private static Connection connection;
    private static Statement statement;

    synchronized static void connect(){
    try {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:chat-server/chat-db");
        statement=connection.createStatement();

    }catch  (ClassNotFoundException  |SQLException e) {
       throw new RuntimeException(e);
    }
    }
    synchronized static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    synchronized static String getNickName(String login, String password){
        String query = String.format("SELECT nickname FROM users where login='%s' and password='%s'",login,password);
        try (ResultSet set= statement.executeQuery(query)){
            if(set.next())
                return set.getString("nickname");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    synchronized static void changeNickName(String login, String password, String nickname){
        String query = String.format("UPDATE users SET nickname='%s' WHERE login='%s' and password='%s'",nickname,login,password);
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
    }

