package com.model;

import lombok.Data;

@Data
public class Question {

    private long id;

    private String text;

    private long pollId;
}
