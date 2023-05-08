package com.orangeandbronze.enlistment;

import java.time.LocalTime;

import static org.apache.commons.lang3.Validate.notNull;

class Schedule {
    private final Days days;
    private final Period period;
    private final LocalTime startTime;
    private final LocalTime endTime;

    Schedule(Days days, Period period, LocalTime startTime, LocalTime endTime) {
        notNull(days);
        notNull(period);

        this.days = days;
        this.period = period;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return days + " " + period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Schedule schedule = (Schedule) o;

        if (days != schedule.days)
            return false;

        return period == schedule.period;
    }

    @Override
    public int hashCode() {
        int result = days != null ? days.hashCode() : 0;
        result = 31 * result + (period != null ? period.hashCode() : 0);

        return result;
    }

    public boolean overlapsWith(Schedule other) {
        return (this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime)) ||
                (other.startTime.isBefore(this.endTime) && other.endTime.isAfter(this.startTime));
    }



}
