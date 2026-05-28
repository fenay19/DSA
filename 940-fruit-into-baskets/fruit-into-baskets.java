class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int max=0;
        int n=fruits.length;
        HashMap<Integer,Integer>map=new HashMap<>();
if(n==1){
    return 1;
}
        for(int h=0;h<n;h++){
  map.put(fruits[h],map.getOrDefault(fruits[h],0)+1);

  while(map.size()>2){
    map.put(fruits[l],map.get(fruits[l])-1);
    if(map.get(fruits[l])==0){
        map.remove(fruits[l]);
    }
    l++;
  }
 
    int res=h-l+1;
    max=Math.max(max,res);
  
        }
        return max;
    }
}