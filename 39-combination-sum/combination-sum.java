import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> d = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        jrl(candidates, target, candidates.length, d, res, 0, 0);
        return res;
    }

    public void jrl(int[] a1, int tar, int n,
                    List<Integer> d,
                    List<List<Integer>> res,
                    int idx, int sum) {

        // Base case
        if (idx == n) {
            if (sum == tar) {
                res.add(new ArrayList<>(d)); // copy
            }
            return;
        }

        // NOT TAKE
        jrl(a1, tar, n, d, res, idx + 1, sum);

        // TAKE
        if (sum + a1[idx] <= tar) {
            d.add(a1[idx]);

            jrl(a1, tar, n, d, res, idx, sum + a1[idx]);

            // BACKTRACK
            d.remove(d.size() - 1);
        }
    }
}