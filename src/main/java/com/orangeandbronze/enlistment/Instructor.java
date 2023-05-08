package com.orangeandbronze.enlistment;

import java.util.*;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

class Instructor {
    private final int instructorNumber;
    private final String firstName;
    private final String lastName;
    private final Collection<Section> assignedSections = new HashSet<>();

    Instructor(int instructorNumber, String firstName, String lastName) {
        this(instructorNumber, firstName, lastName,Collections.emptyList());
    }


//          CANDIDATE FOR DEAD CODE
//    Instructor(int instructorNumber, Section section) {
//        this.instructorNumber = instructorNumber;
//        this.assignedSections.add(section);
//    }

    @Override
    public String toString() {
        return "Instructor# " + this.instructorNumber + " " +  this.firstName + " " + this.lastName;
    }

    Instructor(int instructorNumber, String firstName, String lastName, Collection<Section> sections) {
        notBlank(firstName, "First Name ID cannot be null, empty, or whitespace");
        notBlank(lastName, "Last Name cannot be null, empty, or whitespace");
        this.instructorNumber = instructorNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        sections.forEach(section -> {
            assign(section);
        });
    }

    public Collection<Section> getSections() {
        return new ArrayList<>(assignedSections);
    }

    void assign(Section newSection) {
        notNull(newSection, "Section cannot be null");
        assignedSections.forEach(currentSection -> currentSection.checkForScheduleConflict(newSection));
        this.assignedSections.add(newSection);
    }



}
