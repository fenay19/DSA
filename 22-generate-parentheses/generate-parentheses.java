class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder sb = new StringBuilder();

     str(0,0,n,sb,res);
     return res;
    }

    public void str(int open,int close,int n, StringBuilder sb,List<String> res){
        if(open==n && close==n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            str(open+1,close,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
            
        }
        if(close<open){
            sb.append(')');
            str(open,close+1,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
            
        }
    }
}