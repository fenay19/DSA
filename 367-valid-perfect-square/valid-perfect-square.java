class Solution {
    public boolean isPerfectSquare(int num) {
       int l=1;
       int h=num;
       while(l<=h) {
int m=(l+h)/2;
long sq = (long) m * m;
if(sq==num){
    return true;
}
else if(sq<num){
    l=m+1;
}
else{
    h=m-1;
}



       }
       return false;
    }
}