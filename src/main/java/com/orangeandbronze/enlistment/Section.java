package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

class Section {
    private final String sectionID;
    private final Schedule schedule;
    private final Room room;
    private final Subject subject;


    Section(String sectionID, Schedule schedule, Room room, Subject subject) {
        notBlank(sectionID, "Section ID cannot be null, empty, or whitespace");
        isTrue(isAlphanumeric(sectionID), "Section ID must be alphanumeric, was: " + sectionID);
        notNull(schedule);
        notNull(room);
        notNull(subject);

        this.sectionID = sectionID;
        this.schedule = schedule;
        this.room = room;
        this.subject = subject;
    }

    void checkForScheduleConflict(Section other) {
        notNull(other);
        if (this.schedule.equals(other.schedule)) {
            throw new ScheduleConflictException("Section is in conflict between"
                    + this + " and " + other + " at schedule " + schedule);
        }
    }

    void checkForSubjectConflict(Section other) {
        notNull(other);
        if (this.subject.equals(other.subject)) {
            throw new SubjectConflictException("Subject is in conflict between"
                    + this + " and " + other + " at schedule " + schedule);
        }
    }

    Subject getSubject() {
        return this.subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Section section = (Section) o;

        return sectionID.equals(section.sectionID);
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public int hashCode() {

        return sectionID.hashCode();
    }

    @Override
    public String toString() {

        return sectionID + "Room: " + room;
    }
}
