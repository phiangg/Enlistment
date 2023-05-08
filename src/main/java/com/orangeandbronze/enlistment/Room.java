package com.orangeandbronze.enlistment;

import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

class Room {
    private final String roomName;
    private final int capacity;

    Room(String roomName, int capacity) {
        notBlank(roomName, "Room name cannot be null, empty, or whitespace");
        isTrue(isAlphanumeric(roomName), "Room name must be alphanumeric, was: " + roomName);
        isTrue(capacity > 0, "Capacity must be greater than 0");
        this.roomName = roomName;
        this.capacity = capacity;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return roomName.equals(room.roomName);
    }

    @Override
    public int hashCode() {
        return roomName.hashCode();
    }

    @Override
    public String toString() {
        return roomName + " (Capacity: " + capacity + ")";
    }


}
