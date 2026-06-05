class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        HashSet<String> map=new HashSet<>();
       Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            map.add(wordList.get(i));}
            if(!map.contains(beginWord)){
                map.add(beginWord);

            }
              if(!map.contains(endWord)){
               return 0;

            }

        
        q.offer(new Pair(beginWord,1));
        map.remove(beginWord);

        while(!q.isEmpty()){
        Pair p=q.poll();

        String word=p.word;
        int val=p.steps;
      if(word.equals(endWord)){
        return val;
      }

         char[] arr = word.toCharArray();
        for(int i=0;i<word.length();i++){
             char c=word.charAt(i);
         for(char ch='a'; ch<='z'; ch++){

            if(ch == c) continue;

            arr[i] = ch;

            String newWord = new String(arr);

            if(map.contains(newWord)){
                q.offer(new Pair(newWord, val + 1));
                map.remove(newWord);
            }
        }
       arr[i]=c;


        }



        }
 return 0;

    }

}
    class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}