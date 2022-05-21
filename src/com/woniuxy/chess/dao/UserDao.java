package com.woniuxy.chess.dao;
import com.woniuxy.chess.entity.User;
import com.woniuxy.chess.global_config.JdbcUtils;


import java.sql.*;

public class UserDao {
    public void insert(User user) throws Exception {
        Connection conn = JdbcUtils.getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO user(account,password,reg_time,win_game,lose_game,tie_game,total) VALUES ('" + user.getAccount() + "','" + user.getPassword() + "',now(),'" + user.getWinGame() + "','" + user.getLoseGame() + "','" + user.getTieGame() + "','" + user.getTotal() + "')");

    }

    public void update(User user) throws Exception {
        String sql = "UPDATE USER SET ACCOUNT = ?,PASSWORD=?,REG_TIME=?,WIN_GAME=?,LOSE_GAME=?,TIE_GAME=?,TOTAL=? WHERE ID=?";
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getAccount());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getRegTime());
        pstmt.setInt(4, user.getWinGame());
        pstmt.setInt(5, user.getLoseGame());
        pstmt.setInt(6, user.getTieGame());
        pstmt.setInt(7, user.getTotal());
        pstmt.setInt(8, user.getId());
        pstmt.execute();
    }

    public User getById(int id) throws Exception {
        User user = new User();
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER WHERE ID=?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            user.setId(rs.getInt(1));
            user.setAccount(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setRegTime(rs.getString(4));
            user.setWinGame(rs.getInt(5));
            user.setLoseGame(rs.getInt(6));
            user.setTieGame(rs.getInt(7));
            user.setTotal(rs.getInt(8));
        }
        return user;
    }
    public int getByAccount(String account) throws Exception {
        User user = new User();
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT count(*) FROM USER WHERE ACCOUNT=?");
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        int count = 0;
        while (rs.next()) {
            count=rs.getInt(1);
        }
        return count;
    }
    public String getByPassword(String account) throws Exception{
        User user = new User();
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT PASSWORD FROM USER WHERE ACCOUNT=?");
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        String res = null;
        while (rs.next()) {
            res=rs.getString(1) ;
        }
        return res;
    }

    public int getIdByAccount(String account) throws Exception{
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT ID FROM USER WHERE ACCOUNT=?");
        pstmt.setString(1, account);
        ResultSet rs = pstmt.executeQuery();
        int res = 0;
        while (rs.next()) {
            res=rs.getInt(1) ;
        }
        return res;
    }


    public void delete(User user) throws Exception {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("");
        pstmt.setString(1, "");
        pstmt.execute();
    }
}
