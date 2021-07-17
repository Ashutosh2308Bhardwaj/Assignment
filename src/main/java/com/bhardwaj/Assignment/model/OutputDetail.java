package com.bhardwaj.Assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "ashutosh_bhardwaj_java_output")
public class OutputDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String input;
    private String finalOutput;
    private Integer stepsCount;
    private Timestamp currentTimeStamp;

    public OutputDetail() {
    }

    public OutputDetail(String input, String finalOutput, Integer stepsCount, Timestamp currentTimeStamp) {
        this.input = input;
        this.finalOutput = finalOutput;
        this.stepsCount = stepsCount;
        this.currentTimeStamp = currentTimeStamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getFinalOutput() {
        return finalOutput;
    }

    public void setFinalOutput(String finalOutput) {
        this.finalOutput = finalOutput;
    }

    public Integer getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(Integer stepsCount) {
        this.stepsCount = stepsCount;
    }

    public Timestamp getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(Timestamp currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }
}
