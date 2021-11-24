package com.model;

import lombok.Data;

@Data
public class Result {

    private long id;

    private String explanation;

    private int minScore;

    private int maxScore;

    private long pollId;
}
