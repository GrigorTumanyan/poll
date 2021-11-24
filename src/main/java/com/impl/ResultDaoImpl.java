package com.impl;


import com.ResultDao;
import com.model.Result;
import com.config.ConnectionFactory;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultDaoImpl implements ResultDao {
    private final Connection CONNECTION = new ConnectionFactory().getConnection();

    @SneakyThrows
    @Override
    public List<Result> findAll() {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM RESULT ");
        List<Result> resultList = new ArrayList<>();
        while (resultSet.next()){
            Result result = implementedResult(resultSet);
            resultList.add(result);
        }
        return resultList;
    }

    @SneakyThrows
    @Override
    public Result findById(long id) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM RESULT WHERE id = " + id);
        return implementedResult(resultSet);
    }

    @SneakyThrows
    @Override
    public List<Result> findByPollId(long pollId) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Result WHERE pollId =" + pollId);
        List<Result> resultList = new ArrayList<>();
        while (resultSet.next()){
            Result result = implementedResult(resultSet);
            resultList.add(result);
        }
        return resultList;
    }

    @SneakyThrows
    @Override
    public Result findByScore(long pollId, int score) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM RESULT WHERE pollID = " + pollId + "AND maxScore >= " + score);
        return implementedResult(resultSet);
    }

    @SneakyThrows
    private Result implementedResult(ResultSet resultSet) {
        return new Result()
                .setId(resultSet.getLong("id"))
                .setExplanation(resultSet.getString("explanation"))
                .setPollId(resultSet.getLong("pollId"))
                .setMaxScore(resultSet.getInt("maxScore"))
                .setMinScore(resultSet.getInt("minScore"));
    }
}
