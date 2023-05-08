package com.orangeandbronze.enlistment;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

public class Subject {
    private final String subjectID;
    private final int units;
    private final SubjectType subjectType;

    Subject(String subjectID, int units, SubjectType subjectType) {
        isTrue(isAlphanumeric(subjectID), "Subject ID must be alphanumeric, was: " + subjectID);
        this.subjectID = subjectID;
        this.units = units;
        this.subjectType = subjectType;
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

enum SubjectType {
    LABORATORY, LECTURE
}
