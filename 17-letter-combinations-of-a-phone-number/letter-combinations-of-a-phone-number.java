class Solution {
       Map<Character, String> map = new HashMap<>();

    public Solution() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
     List<String> res = new ArrayList<>();

        if (digits.length() == 0) return res;

        fun2(digits, digits.length(), "", 0, res);
        return res;

    }
        public void fun2(String dig,int n,String diary,int idx,List<String>res){

        if(idx==n){
            res.add(diary);
            return;
        }


        String l=map.get(dig.charAt(idx));

        for(int i=0;i<l.length();i++){
            fun2(dig,n,diary+l.charAt(i),idx+1,res);
        }
}
}