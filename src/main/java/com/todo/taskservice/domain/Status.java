package com.todo.taskservice.domain;

public enum Status {
    TO_DO("TO_DO"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");

    private String value;

    Status(String value){this.value = value;}
    public String getValue(){
        return this.value;
    }
}
