package com.orangeandbronze.enlistment;

import java.time.LocalTime;
import java.time.OffsetDateTime;

import static sun.awt.util.PerformanceLogger.getStartTime;

public enum Period {
    H0830, H1000, H1130, H1300, H1430, H1600;

    private OffsetDateTime start;
    private OffsetDateTime end;

    public OffsetDateTime getStart() {
        return start;
    }

    public void setStart(OffsetDateTime start) {
        this.start = start;
    }

    public OffsetDateTime getEnd() {
        return end;
    }

    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }
}

    

