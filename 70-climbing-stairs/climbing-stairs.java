class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
        return stairs(n,0,map);
    }
    int stairs(int n,int i,HashMap<Integer,Integer> map){
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }
        int a=stairs(n,i+1,map);
        int b=stairs(n,i+2,map);
        int ans=a+b;
        map.put(i,ans);
        return ans;
    }
}