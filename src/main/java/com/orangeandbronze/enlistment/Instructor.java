package com.orangeandbronze.enlistment;

import java.util.*;

import static org.apache.commons.lang3.Validate.notNull;

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

    public Collection<Section> getSections() {
        return new ArrayList<>(assignedSections);
    }

    void assign(Section newSection) {
        notNull(newSection, "Section cannot be null");
        assignedSections.forEach(currentSection -> currentSection.checkForConflict(newSection));
        this.assignedSections.add(newSection);
    }



}
