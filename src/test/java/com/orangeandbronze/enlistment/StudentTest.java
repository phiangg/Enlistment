package com.orangeandbronze.enlistment;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void enlist_1_student_in_2_sections_no_conflict() {
        //Given 1 student & 2 sections w/ no conflict
        Student student = new Student(1, Collections.emptyList());
        Section section1 = new Section("A", new Schedule(Days.MTH, Period.H0830));
        Section section2 = new Section("B", new Schedule(Days.TF, Period.H1300));

        //When the student enlists in both sections
        student.enlist(section1);
        student.enlist(section2);

        //Then both sections should be part of the student's sections and no other sections
        Collection<Section> sections = student.getSections();
        assertAll(
                () -> assertTrue(sections.containsAll(List.of(section1, section2))),
                () -> assertEquals(2, sections.size())
        );
    }

    @Test
    void enlist_1_student_in_2_sections_same_schedule() {
        //Given 1 student with no sections and 2 sections same schedule
        Student student = new Student(1, Collections.emptyList());
        Section section1 = new Section("A", new Schedule(Days.MTH, Period.H0830));
        Section section2 = new Section("B", new Schedule(Days.MTH, Period.H0830));

        //When students enlist in both
        student.enlist(section1);

        //Then at the 2nd enlistment, an exception will be thrown
        assertThrows(Exception.class, () -> student.enlist(section2));

    }
}
