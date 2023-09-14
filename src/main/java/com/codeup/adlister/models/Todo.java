package com.codeup.adlister.models;

public class Todo {
    private String name;
    private boolean isComplete;

    public Todo() {

    }
    public Todo(String name, boolean isComplete) {
        this.name = name;
        this.isComplete = isComplete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
