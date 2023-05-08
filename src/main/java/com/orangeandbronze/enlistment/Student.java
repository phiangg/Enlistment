package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.Validate.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

class Student {

    private final int studentNumber;
    private final Collection<Section> sections;

    Student(int studentNumber, Collection<Section> sections) {
        if (studentNumber < 0)
            throw new IllegalArgumentException("Student Number must be non-negative, was " + studentNumber);
        
        notNull(sections, "Section cannot be null");

        this.studentNumber = studentNumber;
        this.sections = new HashSet<>(sections);
        this.sections.removeIf(Objects::isNull);
    }

    public void enlist(Section section) {
        notNull(section, "Section cannot be null");
        sections.add(section);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

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
