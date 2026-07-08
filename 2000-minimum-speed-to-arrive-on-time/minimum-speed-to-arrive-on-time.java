class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
     if(hour<=dist.length-1) return -1;
        int l=1;
        int h=10000000;
        int res=0;
        while(l<=h){

int m=(l+h)/2;

if(acthrs(dist,dist.length,m)>hour){

l=m+1;


}
else{
    res=m;
    h=m-1;
}


        }
        return res;
    }
    double acthrs(int [] arr,int n,int guess){
double hr=0;

for(int i=0;i<n-1;i++){


    hr+=Math.ceil((double)arr[i]/guess);
}
 hr+=(double)arr[n-1]/guess;

return hr;



    }
}