class Solution {
    public String simplifyPath(String path) {
        Stack<String>st=new Stack<>();
        String [] arr=path.split("/");
        int n=arr.length;
        for(int i=0;i<n;i++){

            if(arr[i].equals("") || arr[i].equals(".")){
                continue;
            }
else if(arr[i].equals("..")){
    if(!st.isEmpty()){
st.pop();
    }

}
        
else{
        st.push(arr[i]);
}

        }
StringBuilder sb=new StringBuilder();
 

for(String res:st){
    sb.append("/").append(res);
}

if(sb.length()==0) return "/";
return sb.toString();
    }
}