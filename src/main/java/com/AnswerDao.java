package com;

import com.model.Answer;

import java.util.List;

public interface AnswerDao extends Dao<Answer> {

    List<Answer> findByQuestionId(long questionId);
}
