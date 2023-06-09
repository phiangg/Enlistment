package com.orangeandbronze.enlistment;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

public class Subject {
    public static final Subject NONE = new Subject("NONE");
    private final String subjectID;
    private final int units;
    private final SubjectType subjectType;
    private final Collection<Subject> prerequisites;

    Subject (String subjectID) {
        this(subjectID, 0, SubjectType.LECTURE);
    }
    Subject(String subjectID, int units, SubjectType subjectType) {
      this(subjectID, units, subjectType, Collections.emptyList());
    }

    Subject (String subjectID, Integer units, SubjectType subjectType, Collection<Subject> prerequisites) {
        isTrue(isAlphanumeric(subjectID), "Subject ID must be alphanumeric, was: " + subjectID);
        notNull(subjectType);
        notNull(prerequisites);

        if (units < 0)
            throw new InvalidUnitException("Unit must be must be non-negative, was: " + units);

        this.subjectID = subjectID;
        this.units = units;
        this.subjectType = subjectType;

        this.prerequisites = new HashSet<>(prerequisites);
        this.prerequisites.removeIf(Objects::isNull);
    }

    void checkForPrerequisite(Collection<Subject> subjects) {
        if(!subjects.contains(this)){
            throw new SubjectConflictException("The student haven't completed the prerequisite subject for " + this);
        }
    }

    Collection<Subject> getPrerequisites() {
        return new ArrayList<>(this.prerequisites);
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

