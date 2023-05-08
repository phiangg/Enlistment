package com.orangeandbronze.enlistment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectTest {
    @Test
    void constructor_with_1_unit_and_lecture_subjectype() {
        assertDoesNotThrow(() -> new Subject("MATH101", 1, SubjectType.LECTURE));
    }

    @Test
    void constructor_with_0_unit() {
        assertDoesNotThrow(() -> new Subject("MATH101", 0, SubjectType.LECTURE));
    }

    @Test
    void constructor_with_negative_unit() {
        assertThrows(InvalidUnitException.class, () -> new Subject("MATH101", -1, SubjectType.LECTURE));
    }
}
