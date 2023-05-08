package com.orangeandbronze.enlistment;

import java.time.LocalTime;

import static org.apache.commons.lang3.Validate.notNull;

class Schedule {
    private final Days days;
    private final Period period;

    Schedule(Days days, Period period) {
        notNull(days);
        notNull(period);

        this.days = days;
        this.period = period;
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
        if (!days.equals(other.days)) {
            return false;
        }

        LocalTime startTime = period.getStart().toLocalTime();
        LocalTime endTime = period.getEnd().toLocalTime();

        LocalTime otherStartTime = other.period.getStart().toLocalTime();
        LocalTime otherEndTime = other.period.getEnd().toLocalTime();

        return (startTime.isAfter(otherStartTime) && startTime.isBefore(otherEndTime)) ||
                (endTime.isAfter(otherStartTime) && endTime.isBefore(otherEndTime)) ||
                (startTime.equals(otherStartTime) && endTime.equals(otherEndTime));
    }


}
