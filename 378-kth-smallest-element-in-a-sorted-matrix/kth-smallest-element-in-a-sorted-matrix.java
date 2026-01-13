class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        int row=matrix.length;
        int col=matrix[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                maxHeap.add(matrix[i][j]);

                if(maxHeap.size()>k){
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}