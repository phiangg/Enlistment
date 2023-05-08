package com.orangeandbronze.enlistment;

import java.util.*;

class Instructor {
    private final int instructorNumber;
    private final Collection<Section> assignedSections = new HashSet<>();

    Instructor(int instructorNumber) {
        this(instructorNumber, Collections.emptyList());
    }

    Instructor(int instructorNumber, Section section) {
        this.instructorNumber = instructorNumber;
        this.assignedSections.add(section);
    }

    Instructor(int instructorNumber, Collection<Section> sections) {
        this.instructorNumber = instructorNumber;
        sections.forEach(section -> {
            assign(section);
        });
    }

    void assign(Section section) {
        this.assignedSections.add(section);
    }



}
