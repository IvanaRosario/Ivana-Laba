package com.solvd.laba.enums;

import java.time.LocalDateTime;

public enum SubjectPeriod {
    FIRST_QUARTER("This subject is taught from March to June", 3),
    SECOND_QUARTER("This subject is taught from August to November", 9),
    ANNUAL("This subject is taught from March to November", 3);

    private String period;
    private int registrationMonth;
    private boolean openRegistration = false;

    SubjectPeriod(String period, int registrationMonth) {
        this.period = period;
        this.registrationMonth = registrationMonth;

        LocalDateTime date = LocalDateTime.now();
        if(isWithinRegistrationPeriod(date)) {
            openRegistration =true;
        }
    }

    private boolean isWithinRegistrationPeriod(LocalDateTime date) {
        return (date.getMonthValue() == registrationMonth &&
                date.getDayOfMonth() <= 30);
    }

    public boolean isOpenRegistration() {
        return this.openRegistration;
    }

    @Override
    public String toString() {
        return "Period" + period +
                "openRegistration=" + openRegistration;
    }

    public String getPeriod() {
        return period;
    }
}
