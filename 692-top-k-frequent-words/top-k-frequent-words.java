class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        for(String ch:words){
             map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
     PriorityQueue<Map.Entry<String, Integer>> pq =
    new PriorityQueue<>((a, b) -> {
        if (!a.getValue().equals(b.getValue()))
            return a.getValue() - b.getValue();   // smaller frequency first
        return b.getKey().compareTo(a.getKey());  // reverse lexicographical
    });

    for (Map.Entry<String, Integer> entry : map.entrySet()){

        pq.offer(entry);


        if(pq.size()>k){
            pq.poll();
        }
    }
    List<String>st=new ArrayList<>();

    while(!pq.isEmpty()){


        st.add(pq.poll().getKey());
    }
 Collections.reverse(st);
 return st;
    }
}