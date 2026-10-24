class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1=0;
        int cand2=0;
        int cnt1=0;
        int cnt2=0;

        for(int x:nums){


if(x==cand1 && cnt1>0){
    cnt1++;
}
else if(x==cand2 && cnt2>0){
    cnt2++;
}
else if(cnt1==0){
    cand1=x;
    cnt1=1;
}
else if(cnt2==0){
    cand2=x;
    cnt2=1;
}
else{
    cnt1--;
    cnt2--;
}



        }


        ArrayList<Integer> ans=new ArrayList<>();
        cnt1=0;
        cnt2=0;


        for(int k:nums){
            if(k==cand1) cnt1++;
            else if(k==cand2) cnt2++;
        }

        if(cnt1>nums.length/3) ans.add(cand1);
         if(cnt2>nums.length/3) ans.add(cand2);

         return ans;
    }
}