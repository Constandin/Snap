package com.woniuxy.chess.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.chess.entity.User;
import com.woniuxy.chess.entity.Record;
import com.woniuxy.chess.global_config.JdbcUtils;

public class RecordDao {
    public void insert(Record record) throws Exception {
        Connection conn = JdbcUtils.getConnection();
//        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO RECORD(BLACK, WHITE, RESULT, FIGHT_TIME) VALUES (?,?,?,NOW())");
        pstmt.setInt(1, record.getBlack());
        pstmt.setInt(2, record.getWhite());
        pstmt.setString(3, record.getResult());
        pstmt.execute();
    }

    public ResultSet selete(Record record) {
        return null;
    }

    public void update(Record record) throws Exception {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("UPDATE RECORD SET BLACK = ?,WHITE = ?,RESULT = ?,FIGHT_TIME = ? WHERE ID = ?");
        pstmt.setInt(1, record.getBlack());
        pstmt.setInt(2, record.getWhite());
        pstmt.setString(3, record.getResult());
        pstmt.setString(4, record.getFightTme());
        pstmt.setInt(5, record.getId());
        pstmt.execute();
    }

    public Record getById(int id) throws Exception {
        Record record = new Record();
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM RECORD WHERE ID=?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            record.setId(rs.getInt(1));
            record.setBlack(rs.getInt(2));
            record.setWhite(rs.getInt(3));
            record.setResult(rs.getString(4));
            record.setFightTme(rs.getString(5));
        }
        return record;
    }

    public void delete(Record record) throws Exception {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("");
        pstmt.setInt(1, record.getBlack());
        pstmt.setInt(2, record.getWhite());
        pstmt.setString(3, record.getResult());
        pstmt.execute();
    }
}
