class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] ans=new int [n];
        for(int []x :bookings){
            int f=x[0];
            int l=x[1];
            int set=x[2];

            for(int i=f-1;i<l;i++){
                ans[i]+=set;
            }
        }
        return ans;
    }
}