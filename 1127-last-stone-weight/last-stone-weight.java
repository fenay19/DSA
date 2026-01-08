class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());

        for(int n:stones){
            maxheap.add(n);
            
        }
        while(maxheap.size()>=2){
            int y=maxheap.poll();
            int x=maxheap.poll();

            if(x==y){
                continue;
            }
         
                int k=y-x;
                maxheap.add(k);
            
        }
        return maxheap.size() ==1?  maxheap.peek():0;
    }
}