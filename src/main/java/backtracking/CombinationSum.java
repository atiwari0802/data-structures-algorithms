package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /**
     * Time Complexity:
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentSolution = new ArrayList<>();
        List<List<Integer>> completeSolution = new ArrayList<>();

        combinationSumHelper(candidates, 0, target, currentSolution, completeSolution);

        return completeSolution;
    }

    private void combinationSumHelper(int[] candidates, int start, int target, List<Integer> currentSolution, List<List<Integer>> completeSolution) {
        if (target == 0) {
            completeSolution.add(new ArrayList<>(currentSolution));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currentSolution.add(candidates[i]);
            combinationSumHelper(candidates, i, target - candidates[i], currentSolution, completeSolution);
            currentSolution.remove(currentSolution.size() - 1);
        }
    }
}
