package com;

import com.model.Result;

import java.util.List;

public interface ResultDao extends Dao<Result> {

    List<Result> findByPollId(long pollId);

    Result findByScore(long pollId, int score);
}
