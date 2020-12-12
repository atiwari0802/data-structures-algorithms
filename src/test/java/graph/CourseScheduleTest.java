package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CourseScheduleTest {

    private CourseSchedule courseSchedule;

    @BeforeEach
    public void setup() {
        courseSchedule = new CourseSchedule();
    }

    @Test
    public void testCourseSchedule() {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        int[] schedule = courseSchedule.findOrder(4, prerequisites);

        for (int i : schedule) {
            System.out.printf(" %d ", i);
        }
    }

    @Test
    public void testWithEmptyInput() {
        int[][] prerequisites = new int[0][0];

        int[] schedule = courseSchedule.findOrder(1, prerequisites);

        for (int i : schedule) {
            System.out.printf(" %d ", i);
        }
    }
}
