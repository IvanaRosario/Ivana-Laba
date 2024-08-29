package main.java.com.solvd.laba;

import java.util.*;

public class Grade {
    private List<String> subject = new ArrayList<>();
    private String student;
    private int score;
    boolean passed = false;

    public Grade(String subject, String student, int score) {
        this.subject.add(subject);
        this.student = student;
        this.score = score;
    }
}
