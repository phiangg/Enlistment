package com.orangeandbronze.enlistment;

class Section {
    private final String sectionID;

    Section(String sectionID) {
        if (sectionID == null)
            throw new NullPointerException("Section ID cannot be null");

        if (sectionID.trim().equals(""))
            throw new IllegalArgumentException("Section was empty or whitespace");

        this.sectionID = sectionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        return sectionID.equals(section.sectionID);
    }

    @Override
    public int hashCode() {
        return sectionID.hashCode();
    }

    @Override
    public String toString() {
        return sectionID;
    }
}
