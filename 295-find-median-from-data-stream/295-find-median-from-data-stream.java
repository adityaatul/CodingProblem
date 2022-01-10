class MedianFinder {
    
    PriorityQueue<Integer> left; // max heap
    PriorityQueue<Integer> right; // min heap
    public MedianFinder() {
        left = new PriorityQueue<Integer>(Collections.reverseOrder()); //By default min heap is created, this will create max heap
        right = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        right.add(num);
        left.add(right.poll());
        if (left.size() > right.size()) {
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek())/2.0;
        }   
        return Double.valueOf(right.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/*

3 5 1 12

1  3 5

*/