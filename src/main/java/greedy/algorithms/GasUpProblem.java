package greedy.algorithms;

public class GasUpProblem {

    /**
     * In this approach, we maintain two variables to maintain surplus and deficit
     * at each index of the array. These variables are calculated as running sums.
     * <p>
     * This strategy is classified because the only
     * choice we can make is to move to the next index.
     * <p>
     * Both surplus and deficit are calculated as:
     * surplus += gas[i] - cost[i];
     * deficit += gas[i] - cost[i];
     * <p>
     * If the surplus becomes negative, that means we cannot travel to the
     * next index. So, the start_index is set to the next index (i + 1) and the
     * surplus is reset to zero.
     * <p>
     * The deficit is not reset and it keeps a track of amount of fuel needed to
     * reach a given index in the array.
     * <p>
     * If we reach the end of the array and the deficit is less than 0, then there is
     * no route around the circuit. If it is zero or positive, it is possible to go
     * around the circuit.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param gas
     * @param cost
     * @return starting point of the circuit that will let us go around, if it exists.
     * -1 otherwise.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0, deficit = 0, startingPoint = 0;
        int stations = gas.length;

        for (int i = 0; i < stations; i++) {
            surplus += gas[i] - cost[i];
            deficit += gas[i] - cost[i];

            if (surplus < 0) {
                surplus = 0;
                startingPoint = i + 1;
            }
        }

        return deficit < 0 ? -1 : startingPoint;
    }
}
