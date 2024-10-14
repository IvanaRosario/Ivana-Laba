package com.solvd.laba.enums;

public enum SubjectState {
    TAKING("Taking subject", true),
    RETAKING("Retaking subject", true),
    PASSED("Passed subject", false);

    private String state;
    private boolean enrolled;

    SubjectState(String state, boolean enrolled) {
        this.state = state;
        this.enrolled = enrolled;
    }

    public String getState() {
        return state;
    }

    public boolean isEnrolled() {
        return enrolled;
    }
}
