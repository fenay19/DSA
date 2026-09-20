class Solution {
    public int longestConsecutive(int[] nums) {
         HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
for(int n:set){
    if(!set.contains(n-1)){
        int curr=n;
        int cnt=1;

        while(set.contains(curr+1)){
            curr++;
            cnt++;
        }
        ans=Math.max(ans,cnt);
    }
}
return ans;
    }
}