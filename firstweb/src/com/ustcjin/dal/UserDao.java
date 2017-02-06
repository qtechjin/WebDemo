package com.ustcjin.dal;

import com.ustcjin.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 2017/2/6.
 */
public class UserDao {

    public static User getUserById(int id) {
        User user = null;
        try {
            String sql = "SELECT * FROM tb_user where user_id=?";
            Connection conn = DBUtils.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<User> getUsersByName(String name){
        List<User> listUser = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_user where user_name=?";
            Connection conn = DBUtils.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt("user_id"), rs.getString("user_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    public static boolean updateUserById(int id){
        return true;
    }
}
