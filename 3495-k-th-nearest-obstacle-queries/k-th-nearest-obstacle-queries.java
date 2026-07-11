class Solution {
    public int[] resultsArray(int[][] q, int k) {
        int [] res=new int[q.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
int sum=0;

        for(int i=0;i<q.length;i++){


int x=q[i][0];
int y=q[i][1];
sum=Math.abs(x)+Math.abs(y);
pq.offer(sum);

if(pq.size()>k) pq.poll();


if(pq.size()<k){
    res[i]=-1;
}
else{
    res[i]=pq.peek();
}



        }
        return res;
    }
}