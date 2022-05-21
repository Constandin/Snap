package com.woniuxy.chess.service;

import com.woniuxy.chess.dao.RecordDao;
import com.woniuxy.chess.dao.UserDao;
import com.woniuxy.chess.entity.Record;
import com.woniuxy.chess.entity.User;

import java.sql.SQLException;
import java.util.Objects;


public class RecordService {
    public void addRecord(Record record) {
        UserDao ud = new UserDao();
        RecordDao rd = new RecordDao();
        User balcku;
        User whiteu;
        try {
            balcku = ud.getById(record.getBlack());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            whiteu = ud.getById(record.getWhite());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        record.setBlack(record.getBlack());
        record.setWhite(record.getWhite());
        record.setResult(record.getResult());
        if (Objects.equals(record.getResult(), "白胜")) {
            whiteu.setWinGame(whiteu.getWinGame() + 1);
            whiteu.setTotal(whiteu.getTotal() + 1);
            balcku.setLoseGame(balcku.getLoseGame() + 1);
            balcku.setTotal(balcku.getTotal() + 1);
        } else {
            balcku.setWinGame(balcku.getWinGame() + 1);
            balcku.setTotal(balcku.getTotal() + 1);
            whiteu.setLoseGame(whiteu.getLoseGame() + 1);
            whiteu.setTotal(whiteu.getTotal() + 1);
        }
        try {
            ud.update(whiteu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ud.update(balcku);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            rd.insert(record);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

