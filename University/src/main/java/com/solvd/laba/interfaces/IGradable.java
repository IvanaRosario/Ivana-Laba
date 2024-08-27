package main.java.com.solvd.laba.interfaces;

import main.java.com.solvd.laba.StudentZ;
import main.java.com.solvd.laba.exceptions.GradeOutOfBoundsException;

public interface IGradable  {
    void assignGrade(StudentZ student, double score) throws GradeOutOfBoundsException;

}
