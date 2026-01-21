class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->{
            int diffa=Math.abs(a-x);
            int diffb=Math.abs(b-x);

            if(diffa==diffb){
                return b-a;
            }
            return diffb-diffa;
        }
        );
        for(int n:arr){
            maxheap.add(n);

            if(maxheap.size()>k){
                maxheap.poll();
            }
        }

        List<Integer> list=new ArrayList<>(maxheap);

        Collections.sort(list);


      
        
        return list;
      
        }
    }