package greedy.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QueueReconstructionByHeightTest {

  private QueueReconstructionByHeight queueReconstructionByHeight;

  @BeforeEach
  public void setup() {
    queueReconstructionByHeight = new QueueReconstructionByHeight();
  }

  @Test
  public void testQueueReconstruction() {
    int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

    int[][] result = queueReconstructionByHeight.reconstructQueue(input);

    Arrays.asList(result)
            .forEach(i -> System.out.printf(" %d, %d ->", i[0], i[1]));
  }
}
