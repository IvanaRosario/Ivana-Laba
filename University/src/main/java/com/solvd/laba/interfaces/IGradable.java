package com.solvd.laba.interfaces;

import com.solvd.laba.StudentZ;
import com.solvd.laba.exceptions.GradeOutOfBoundsException;

public interface IGradable  {
    void assignGrade(StudentZ student, double score) throws GradeOutOfBoundsException;

}
