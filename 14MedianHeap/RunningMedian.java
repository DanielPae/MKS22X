public class RunningMedian{
    private MyHeap maxHeap, minHeap;

    public RunningMedian(){
	maxHeap = new MyHeap();
	minHeap = new MyHeap(false);
    }

    public void add(int value){
	if(value > minHeap.peak()){
	    minHeap.add(value);
	}else{
	    maxHeap.add(value);
	}
	if(maxHeap.size >= minHeap.size + 2){
	    minHeap.add(maxHeap.remove());
	}else if(minHeap.size >= maxHeap.size + 2){
	    maxHeap.add(minHeap.remove());
	}
    }

    public double getMedian(){
	if(maxHeap.size == minHeap.size){
	    return 1.0 * (minHeap.peak() + maxHeap.peak()) / 2;
	}else if(maxHeap.size > minHeap.size){
	    return 1.0 * maxHeap.peak();
	}else return 1.0 * minHeap.peak();
    }

    public static void main(String[] args){
    }
}
