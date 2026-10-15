
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gs = 0;
        int cs = 0;

        for (int x : gas) {
            gs += x;
        }

        for (int k : cost) {
            cs += k;
        }

        if (gs < cs) {
            return -1;
        }

        int st = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];

            if (tank < 0) {
                st = i + 1;
                tank = 0;
            }
        }

        return st;
    }
}
