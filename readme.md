# Requirements:

- A section has room
- A room is identified by its room name, which is   alphanumeric.
- A room has a capacity
- Section enlistment may not exceed the capacity of its room.
- A section has a subject. (just 1 subject, not 'block section')
- A subject is identified by its alphanumeric Subject ID.
- A student cannot enlist in two sections with the same subject.
- A subject may or may not have one or more prerequisite subjects.
- A student may not enlist in a section if the student has not yet taken the prerequisite subjects.
- Sections cannot share the same room if their schedules are overlapping.
- A section must have an instructor.
- An instructor cannot teach two or more sections with overlapping schedule.
- A student may cancel an enlisted section.
- Each subject has a corresponding number of units.
- Some subjects may be designated as "laboratory" subjects.
- A student can request to be assessed, which is simply a request for total amount of money that the student will need to pay. It is computed as follows:
    - Each unit is ₱2,000
    - Laboratory subjects have an additional ₱1,000 laboratory fee per subject
    - Miscellaneous fees are ₱3,000
    - Value Added Tax (VAT) is 12%

```
Student , Instructor -> Section
Section -> Room (enum)
Subject (enum)
```

```java
Student(int studentNumber, Collection<Section> sections)
Student(int studentNumber, Collection<Section> sections, Collection<Subjects> subjectsTaken)
Instructor(int instructorNumber, Collection<Section> sections)

Section(String sectionId, Schedule schedule, Subject subject, Room room)
Room(String roomName, int capacity) # consider enum for roomName
Subject(String subjectId, int units, Designation designation)
Subject(String subjectId, int units, Designation designation, Collection<Subject> preRequisites)
```


