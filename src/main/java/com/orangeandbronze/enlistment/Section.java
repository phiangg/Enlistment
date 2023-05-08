package com.orangeandbronze.enlistment;

import java.time.LocalTime;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

class Section {
    private final String sectionID;
    private final Schedule schedule;
    private final Room room;
    private final Subject subject;
    private final LocalTime startTime;
    private final LocalTime endTime;


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
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
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

    void checkForRoomConflict(Section other) {
        notNull(other);
        if (this.room.equals(other.room) && this.schedule.equals(other.schedule)) {
            throw new RoomConflictException("Room is in conflict between "
                    + this + " and " + other + " at schedule " + schedule);
        }
    }

    Subject getSubject() {

        return this.subject;
    }

    Room getRoom() {

        return room;
    }

    public boolean canShareRoomWith(Section other) {
        return this.room.equals(other.room) && this.schedule.overlapsWith(other.schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return Objects.equals(sectionID, section.sectionID) && Objects.equals(subject, section.subject) && Objects.equals(schedule, section.schedule) && Objects.equals(room, section.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionID, subject, schedule, room);
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId='" + sectionID + '\'' +
                ", subject='" + subject + '\'' +
                ", schedule=" + schedule +
                ", room=" + room +
                '}';
    }
}
