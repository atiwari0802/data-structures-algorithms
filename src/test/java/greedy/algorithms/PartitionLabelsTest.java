package greedy.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PartitionLabelsTest {

    private PartitionLabels partitionLabels;

    @BeforeEach
    public void setup() {
        partitionLabels = new PartitionLabels();
    }

    @Test
    public void testPartitionLabels() {
        String input = "ababcbacadefegdehijhklij";

        List<Integer> partitions = partitionLabels.partitionLabels(input);

        partitions.forEach(i -> System.out.printf(" %d , ", i));
    }
}
