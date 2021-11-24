package com.impl;


import com.Dao;
import com.model.Poll;
import com.config.ConnectionFactory;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PollDaoImpl implements Dao<Poll> {
    private final Connection CONNECTION = new ConnectionFactory().getConnection();

    @SneakyThrows
    @Override
    public List<Poll> findAll() {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM POLL");
        List<Poll> pollList = new ArrayList<>();
        while (resultSet.next()){
            Poll poll = implementedPoll(resultSet);
            pollList.add(poll);
        }
        return pollList;
    }

    @SneakyThrows
    @Override
    public Poll findById(long id) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM Answer Where id = " + id);
        return implementedPoll(resultSet);
    }

    @SneakyThrows
    private Poll implementedPoll(ResultSet resultSet) {
        return new Poll()
                .setId(resultSet.getLong("id"))
                .setName(resultSet.getString("name"))
                .setDescription(resultSet.getString("description"));
    }
}
