package greedy.algorithms;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MeetingRooms {

    public int minRooms(int[][] intervals) {
        int size = intervals.length;
        List<Integer> starts = new ArrayList<>(Collections.nCopies(size, 0));
        List<Integer> ends = new ArrayList<>(Collections.nCopies(size, 0));

        for (int i = 0; i < size; i++) {
            starts.set(i, intervals[i][0]);
            ends.set(i, intervals[i][1]);
        }

        starts.sort(Comparator.comparing(a -> a));
        ends.sort(Integer::compare); // same as above

        int startIndex = 0, endIndex = 0;
        int rooms = 0;

        while (startIndex < size) {
            if (starts.get(startIndex) < ends.get(endIndex)) {
                rooms++;
                startIndex++;
            } else {
                rooms--;
                endIndex++;
            }
        }

        return rooms;
    }
}
