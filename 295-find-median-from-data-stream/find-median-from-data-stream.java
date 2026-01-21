class MedianFinder {
PriorityQueue<Integer>minheap;
PriorityQueue<Integer>maxheap;

    public MedianFinder() {
        minheap=new PriorityQueue<Integer>();
        maxheap=new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());

        if(minheap.size()>maxheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()){
            return( maxheap.peek()+minheap.peek())/2.0;
        }
       
            return maxheap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */