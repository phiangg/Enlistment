package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.Validate.*;

import java.util.*;

class Student {

    private final int studentNumber;
    private final Collection<Section> sections;
    private final Collection<Subject> subjectsTaken;

    Student (int studentNumber) {
        this(studentNumber, Collections.emptyList(), Collections.emptyList());
    }

    Student(int studentNumber, Collection<Section> sections) {
        this(studentNumber, sections, Collections.emptyList());
    }

    Student(int studentNumber, Collection<Section> sections, Collection<Subject> subjectsTaken) {

        if (studentNumber < 0)
            throw new IllegalArgumentException("Student Number must be non-negative, was " + studentNumber);

        notNull(sections, "Section cannot be null");
        notNull(subjectsTaken, "Subjects taken cannot be null");

        this.studentNumber = studentNumber;
        this.sections = new HashSet<>(sections);
        this.sections.removeIf(Objects::isNull);
        this.subjectsTaken = new HashSet<>(subjectsTaken);
        this.subjectsTaken.removeIf(Objects::isNull);
    }

    public void enlist(Section newSection) {
        notNull(newSection, "Section cannot be null");
        sections.forEach(currentSection -> currentSection.checkForScheduleConflict(newSection));
        sections.forEach(currentSection -> currentSection.checkForSubjectConflict(newSection));
        sections.add(newSection);
    }

    public Collection<Section> getSections() {
        return new ArrayList<>(sections);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student) o;

        return studentNumber == student.studentNumber;
    }

    @Override
    public int hashCode() {

        return studentNumber;
    }

    @Override
    public String toString() {

        return "Student# " + studentNumber;
    }
}
