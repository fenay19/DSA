class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        int j = 0;
        int cnt = 0;

        HashMap<Integer, int[]> seen = new HashMap<>();

        int k = 0;

        while (k < n1) {
            k++;

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;

                    if (j == s2.length()) {
                        cnt++;
                        j = 0;
                    }
                }
            }

            if (seen.containsKey(j)) {
                int[] prev = seen.get(j);

                int prevK = prev[0];
                int prevCnt = prev[1];

                int cycleK = k - prevK;
                int cycleCnt = cnt - prevCnt;

                int remaining = n1 - k;
                int cycles = remaining / cycleK;

                k += cycles * cycleK;
                cnt += cycles * cycleCnt;

                seen.clear();
            } else {
                seen.put(j, new int[]{k, cnt});
            }
        }

        return cnt / n2;
    }
}