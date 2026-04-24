class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n=moves.length();
        int cnt=0;
        int l=0;
        int r=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='_'){
              cnt++;
            }
            else if(moves.charAt(i)=='L'){
                l--;
            }
            else if(moves.charAt(i)=='R'){
                r++;
            }
            
        }
        return Math.abs(l+r)+cnt;

    }
}