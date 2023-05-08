package com.orangeandbronze.enlistment;

class Student {

    private final int studentNumber;

    Student(int studentNumber) {
        if (studentNumber < 0)
            throw new IllegalArgumentException("Student Number must be non-negative, was " + studentNumber);

        this.studentNumber = studentNumber;
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
