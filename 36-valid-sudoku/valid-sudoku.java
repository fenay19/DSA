class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int j=0;j<m;j++){
            HashMap<Character,Integer> map=new HashMap<>();

            for(int i=0;i<n;i++){

            if(board[i][j]=='.'){
                continue;
            }
            if(map.containsKey(board[i][j])){
                return false;
            }
            map.put(board[i][j],map.getOrDefault(board[i][j],0)+1);

            }
        }

           for(int i=0;i<n;i++){
            HashMap<Character,Integer> map=new HashMap<>();

            for(int j=0;j<m;j++){

            if(board[i][j]=='.'){
                continue;
            }
            if(map.containsKey(board[i][j])){
                return false;
            }
            map.put(board[i][j],map.getOrDefault(board[i][j],0)+1);

            }
        }
for (int r = 0; r < 9; r += 3) {          // Loop 1
    for (int c = 0; c < 9; c += 3) {      // Loop 2

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = r; i < r + 3; i++) { // Loop 3
            for (int j = c; j < c + 3; j++) { // Loop 4

                char ch = board[i][j];

                if (ch == '.') continue;

                if (map.containsKey(ch)) return false;

                map.put(ch, 1);
            }
        }
    }
}






        return true;
    }
}