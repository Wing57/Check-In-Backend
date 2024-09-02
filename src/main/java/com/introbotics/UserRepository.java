package com.introbotics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.introbotics.tables.User;
import com.introbotics.DatabaseConnections;


public class UserRepository {
    
    public void insertUser(User user) {
        String sql = "INSERT INTO Users(name, role) VALUES(?, ?)";

        try (Connection conn = DatabaseConnections.connect();
             PreparedStatement pstmnt = conn.prepareStatement(sql)) {
                pstmnt.setString(1, user.getName());
                pstmnt.setString(2, user.getRole());
                pstmnt.executeUpdate();

                try (ResultSet generatedKeys = pstmnt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserID(generatedKeys.getInt(1));
                    }
                }
             } catch (SQLException e) {
                System.err.println(e.getMessage());
             }
    }

    public void updateUser(User user) {
        String sql = "UPDATE Users SET name = ?, role = ? WHERE user_id = ?";

        try (Connection conn = DatabaseConnections.connect();
             PreparedStatement pstmnt = conn.prepareStatement(sql)) {
                pstmnt.setString(1, user.getName());
                pstmnt.setString(2, user.getRole());
                pstmnt.setInt(3, user.getUserID());
                pstmnt.executeUpdate();
             } catch (SQLException e) {
                System.err.println(e.getMessage());
             }
    }

    public void deleteUser(User user) {
        String sql = "DELETE FROM Users WHERE user_id = ?";

        try (Connection conn = DatabaseConnections.connect();
             PreparedStatement pstmnt = conn.prepareStatement(sql)) {
                pstmnt.setInt(1, user.getUserID());
                pstmnt.executeUpdate();
             } catch (SQLException e) {
                System.err.println(e.getMessage());
             }
    }

    public User getUser(int id) {
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        User user = null;

        try (Connection conn = DatabaseConnections.connect();
             PreparedStatement pstmnt = conn.prepareStatement(sql)) {
                pstmnt.setInt(1, id);

                ResultSet rs = pstmnt.executeQuery();

                if (rs.next()) {
                    user = new User();
                    user.setName(rs.getString("name"));
                    user.setRole(rs.getString("role"));
                    user.setUserID(rs.getInt("user_id"));
                } else {
                    System.out.println("No user found with user_id: " + id);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

            return user;
        }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        List<User> users = new ArrayList<>();

        try (Connection conn = DatabaseConnections.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
    
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    
        return users;
    }
}    

