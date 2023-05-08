package com.orangeandbronze.enlistment;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static com.orangeandbronze.enlistment.Period.*;
import static com.orangeandbronze.enlistment.Days.*;
import static com.orangeandbronze.enlistment.SubjectType.LECTURE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SectionTest {

    private LocalTime startTime;
    private LocalTime endTime;
    private final Schedule MTH_H0830 = new Schedule(MTH, H0830, startTime, endTime);
    private final Schedule MTH_H1300 = new Schedule(MTH, H1300, startTime, endTime);
    final Room ROOM101_5 = new Room("ROOM101", 5);
    final Room ROOM201_5 = new Room("ROOM201", 5);
    final Subject MATH101_3_LECTURE = new Subject("MATH101", 3, LECTURE);
    final Subject MATH201_2_LECTURE = new Subject("MATH201", 2, LECTURE);

    @Test
    public void testCanShareRoomWithSameRoom() {
        Section section1 = new Section("Math", MTH_H0830, ROOM101_5, MATH101_3_LECTURE);
        Section section2 = new Section("Science", MTH_H1300, ROOM101_5, MATH101_3_LECTURE);

        assertTrue(section1.canShareRoomWith(section2));
    }

    @Test
    public void testCannotShareRoomWithDifferentRoom() {
        Section section1 = new Section("Math", MTH_H0830, ROOM101_5, MATH101_3_LECTURE);
        Section section2 = new Section("Science", MTH_H1300, ROOM201_5, MATH201_2_LECTURE);

        assertFalse(section1.canShareRoomWith(section2));
    }

    /*@Test
    void new_section_with_instructor_conflict () {

    }*/
}
