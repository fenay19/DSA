class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        List<String> res=new ArrayList<>();
int j=0;

        for(int i=0;i<s.length();i++){

          if(i-j+1>=10){
      
            String sub=s.substring(j,i+1);
            map.put(sub,map.getOrDefault(sub,0)+1);

            j++;

         }

        }


for(Map.Entry<String,Integer> e:map.entrySet()){
    if(e.getValue()>1){
        res.add(e.getKey());
    }
}

return res;
    }
}