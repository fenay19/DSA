class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        int n=ranks.length;
        long l=1;
        long h=1L*ranks[0]*cars*cars;

        long res=0;
        while(l<=h){
            long m=(l+h)/2;


            if(repairtime(ranks,n,m)<cars){
                l=m+1;
            }
            else{
                res=m;
                h=m-1;
            }
        }
        return res;
    }

    long repairtime(int [] ranks,int n,long time){
long cr=0;
long carcnt=0;
for(int i=0;i<n;i++){
carcnt=  (long)Math.sqrt((double)time/ranks[i]);

cr+=carcnt;



}

return cr;




    }
}