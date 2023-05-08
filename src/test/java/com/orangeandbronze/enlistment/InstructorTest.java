package com.orangeandbronze.enlistment;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.orangeandbronze.enlistment.Days.MTH;
import static com.orangeandbronze.enlistment.Days.TF;
import static com.orangeandbronze.enlistment.Period.H0830;
import static com.orangeandbronze.enlistment.Period.H1300;
import static com.orangeandbronze.enlistment.SubjectType.LECTURE;
import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    final Schedule MTH_0830 = new Schedule(MTH, H0830, startTime, endTime);
    final Schedule TF_1300 = new Schedule(TF, H1300, startTime, endTime);

    @Test
    void assign_1_instructor_in_2_sections_no_conflict() {
        //Given 1 student & 2 sections w/ no conflict
        Instructor instructor = new Instructor(1, "John", "Doe");
        Section section1 = new Section("A", MTH_0830, new Room("TEST", 1), new Subject("MATH101", 1, LECTURE));
        Section section2 = new Section("B", TF_1300, new Room("TEST2" ,2), new Subject("MATH201", 2, LECTURE));

        //When the student enlists in both sections
        instructor.assign(section1);
        instructor.assign(section2);

        //Then both sections should be part of the student's sections and no other sections
        Collection<Section> sections = instructor.getSections();
        assertAll(
                () -> assertTrue(sections.containsAll(List.of(section1, section2))),
                () -> assertEquals(2, sections.size())
        );
    }

    @Test
    void assign_1_instructor_in_2_sections_same_schedule() {
        //Given 1 student with no sections and 2 sections same schedule

        Instructor instructor = new Instructor(1, "John", "Doe");
        Section section1 = new Section("A", MTH_0830, new Room("TEST1", 1), new Subject("ENGLISH101", 1, LECTURE));
        Section section2 = new Section("B", MTH_0830, new Room("TEST2", 2), new Subject("ENGLISH201", 2, LECTURE));

        //When students enlist in both
        instructor.assign(section1);

        //Then at the 2nd enlistment, an exception will be thrown
        assertThrows(ScheduleConflictException.class, () -> instructor.assign(section2));
    }
}
