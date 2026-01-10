import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Each element: {numberOfSoldiers, rowIndex}
        List<int[]> list = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            int soldiers = 0;

            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1) {
                    soldiers++;
                } else {
                    break; // rows are sorted, no more soldiers
                }
            }

            list.add(new int[]{soldiers, row});
        }

        // Sort by soldiers first, then row index
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[1]; // get row index
        }

        return res;
    }
}

