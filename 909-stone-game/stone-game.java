class Solution {
    public boolean stoneGame(int[] piles) {
        int turn=0;
        int j=piles.length-1;
        int i=0;
        int a=0;
        int b=0;
        while(i<j){
            if(turn%2==0 && piles[i]>=piles[j]){
                a+=piles[i];
                i++;
                turn++;
            }
            else if(turn%2==0 && piles[i]<piles[j]){
                   a+=piles[j];
                j--;
                turn++;
            }
            else if(turn%2!=0 && piles[i]>=piles[j]){
                b+=piles[j];
                j--;
                turn++;
            }
            else{
              
                  b+=piles[i];
                i++;
                turn++;
            }


        }

        if(a>b){
            return true;
        }
        else{
            return false;
        }

    }
}