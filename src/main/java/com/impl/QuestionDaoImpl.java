package com.impl;

import com.QuestionDao;
import com.model.Question;
import com.config.ConnectionFactory;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private final Connection CONNECTION = new ConnectionFactory().getConnection();

    @SneakyThrows
    @Override
    public List<Question> findAll() {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM QUESTION");
        List<Question> questionList = new ArrayList<>();
        while (resultSet.next()){
            Question question = implementedQuestion(resultSet);
            questionList.add(question);
        }
        return questionList;
    }

    @SneakyThrows
    @Override
    public Question findById(long id) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM Answer Where id = " + id);
        return implementedQuestion(resultSet);
    }

    @SneakyThrows
    @Override
    public List<Question> findByPollId(long pollId) {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * FROM Answer Where pollId = " + pollId);
        List<Question> questionList = new ArrayList<>();
        while (resultSet.next()) {
            Question question = implementedQuestion(resultSet);
            questionList.add(question);
        }
        return questionList;
    }

    @SneakyThrows
    private Question implementedQuestion(ResultSet resultSet) {
        return new Question()
                .setId(resultSet.getLong("id"))
                .setText(resultSet.getString("text"))
                .setPollId(resultSet.getLong("pollId"));
    }
}
