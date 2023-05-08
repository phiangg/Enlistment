package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

class Section {
    private final String sectionID;
    private final Schedule schedule;

    Section(String sectionID, Schedule schedule) {
        notBlank(sectionID, "Section ID cannot be null, empty, or whitespace");
        isTrue(isAlphanumeric(sectionID), "Section ID must be alphanumeric, was: " + sectionID);
        notNull(schedule);

        this.sectionID = sectionID;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        return sectionID.equals(section.sectionID);
    }

    @Override
    public int hashCode() {
        return sectionID.hashCode();
    }

    @Override
    public String toString() {
        return sectionID;
    }
}
