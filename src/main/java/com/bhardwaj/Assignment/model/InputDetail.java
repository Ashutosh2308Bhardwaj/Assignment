package com.bhardwaj.Assignment.model;

import javax.persistence.*;

@Entity(name = "input_details")
public class InputDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String inputString;

    public InputDetail(Integer id, String input) {
        this.id = id;
        this.inputString = input;
    }

    public InputDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String input) {
        this.inputString = input;
    }
}
