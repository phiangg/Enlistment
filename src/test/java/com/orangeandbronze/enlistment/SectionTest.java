package com.orangeandbronze.enlistment;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static com.orangeandbronze.enlistment.Period.*;
import static com.orangeandbronze.enlistment.Days.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SectionTest {

    private LocalTime startTime;
    private LocalTime endTime;
    private final Schedule MTH_H0830 = new Schedule(MTH, H0830, startTime, endTime);
    private final Schedule MTH_H1300 = new Schedule(MTH, H1300, startTime, endTime);
    private final Room ROOM_101 = new Room("101", 50);
    private final Room ROOM_102 = new Room("102", 60);

    @Test
    public void testCanShareRoomWithSameRoom() {
        Section section1 = new Section("Math", MTH_H0830, ROOM_101, Subject.NONE);
        Section section2 = new Section("Science", MTH_H1300, ROOM_101, Subject.NONE);

        assertTrue(section1.canShareRoomWith(section2));
    }

    @Test
    public void testCannotShareRoomWithDifferentRoom() {
        Section section1 = new Section("Math", MTH_H0830, ROOM_101, Subject.NONE);
        Section section2 = new Section("Science", MTH_H1300, ROOM_102, Subject.NONE);

        assertFalse(section1.canShareRoomWith(section2));
    }

    /*@Test
    void new_section_with_instructor_conflict () {

    }*/
}
