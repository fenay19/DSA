class Solution {
    public int numRescueBoats(int[] people, int limit) {
             int i=0;
             int j=people.length-1;
             Arrays.sort(people);
             int cnt=0;
while(i<=j){
if(people[i]+people[j]<=limit){

cnt++;
i++;
j--;
}
else{
if(people[j]<=limit){
    cnt++;

}
j--;
}



}
return cnt;
    }
}