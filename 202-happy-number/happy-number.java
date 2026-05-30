class Solution {
   
    public boolean isHappy(int n) {
        int s=n;
        int f=n;
       
        while(f!=1){
     s=val(s);
        f=val(f);
        f=val(f);
        if(s==f && s!=1){
            return false;
        }
        }
        return true;
    }
     public int val(int n){
        int sum=0;
        while(n>0){
            int r=n%10;
            n=n/10;
            sum+=r*r;
        }
        return sum;
    }
}