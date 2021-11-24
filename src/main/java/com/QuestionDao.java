package com;

import com.model.Question;

import java.util.List;

public interface QuestionDao extends Dao<Question> {

    List<Question> findByPollId(long pollId);
}
