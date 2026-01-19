class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minheap= new PriorityQueue<>();


        int bid=0;

        while(bid<heights.length-1){
           int diff =heights[bid+1]-heights[bid];

           if(diff<=0){
            bid=bid+1;
            continue;
           }
            if(ladders>0){
                ladders=ladders-1;
                minheap.add(diff);
                bid=bid+1;
            }

            else if(bricks>0){
                int minLadderdiff = minheap.isEmpty()?0:minheap.peek();

                if(minheap.isEmpty()){
                   bricks=bricks-diff;
                }
                else if(diff>minLadderdiff){
                    bricks=bricks-minheap.poll();
                    minheap.add(diff);
                }
                else{
                    bricks=bricks-diff;
                }

                if(bricks<0){
                    return bid;
                }
                bid++;
                continue;


            }
            else{
                return bid;
            }
        }
        return bid;
    }
}