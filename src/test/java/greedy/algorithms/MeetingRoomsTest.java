package greedy.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MeetingRoomsTest {

    private MeetingRooms meetingRooms;

    @BeforeEach
    public void setup() {
        meetingRooms = new MeetingRooms();
    }

    @Test
    public void testMinimumMeetingRooms() {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

        int rooms = meetingRooms.minRooms(intervals);

        Assertions.assertEquals(2, rooms);
    }
}
