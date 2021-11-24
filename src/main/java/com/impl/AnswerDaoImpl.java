package com.impl;
import com.AnswerDao;


import com.config.ConnectionFactory;
import lombok.SneakyThrows;
import com.model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerDaoImpl implements AnswerDao {
    private final Connection CONNECTION = new ConnectionFactory().getConnection();

    @SneakyThrows
    @Override
    public List<Answer> findAll() {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ANSWER");
        List<Answer> allAnswer = new ArrayList<>();
        while (resultSet.next()) {
            Answer answer = implementedAnswer(resultSet);
            allAnswer.add(answer);
        }
        return allAnswer;

    }

    @SneakyThrows
    @Override
    public Answer findById(long id) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Answer Where id = " + id);
        return implementedAnswer(resultSet);
    }

    @SneakyThrows
    @Override
    public List<Answer> findByQuestionId(long questionId) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM Answer Where questionId = " + questionId);
        List<Answer> answersListByQuestionId = new ArrayList<>();
        while (resultSet.next()) {
            Answer answer = implementedAnswer(resultSet);
            answersListByQuestionId.add(answer);
        }
        return answersListByQuestionId;
    }

    @SneakyThrows
    private Answer implementedAnswer(ResultSet resultSet) {
        return new Answer()
                .setId(resultSet.getLong("id"))
                .setText(resultSet.getString("text"))
                .setWeight(resultSet.getInt("weight"))
                .setQuestionId(resultSet.getLong("questionId"));
    }
}
