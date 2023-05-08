package com.orangeandbronze.enlistment;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

public class Subject {
    private final String subjectID;

    public Subject(String subjectID) {
        isTrue(isAlphanumeric(subjectID), "Subject ID must be alphanumeric, was: " + subjectID);
        this.subjectID = subjectID;
    }

    @Override
    public String toString() {
        return subjectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return Objects.equals(subjectID, subject.subjectID);
    }

    @Override
    public int hashCode() {
        return subjectID != null ? subjectID.hashCode() : 0;
    }
}
