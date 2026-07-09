class Solution {
    public int findKthLargest(int[] arr, int k) {
          PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            
            pq.offer(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            
            if(arr[i]<pq.peek()){
                continue;
            }
            pq.poll();
            pq.offer(arr[i]);
            
            
        }
        return pq.poll();
    } 
    }
