package com.model;

import lombok.Data;

@Data
public class Answer {

    private long id;

    private String text;

    private int weight;

    private long questionId;
}
