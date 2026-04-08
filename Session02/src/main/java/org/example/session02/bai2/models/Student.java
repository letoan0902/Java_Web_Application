package org.example.session02.bai2.models;

public class Student {
    private final String fullName;
    private final int score;

    public Student(String fullName, int score) {
        this.fullName = fullName;
        this.score = score;
    }

    public String getFullName() {
        return fullName;
    }

    public int getScore() {
        return score;
    }
}

