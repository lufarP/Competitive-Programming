
import java.util.*;
import java.lang.*;
import java.io.*;
class RunningMedian
 {
    static Scanner sc=new Scanner(System.in);
    static StringBuilder answer=new StringBuilder();
    public static void add(int num,PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap)
    {
        if(maxHeap.isEmpty())
            maxHeap.add(num);
        else
        {
            int median=findMedian(minHeap,maxHeap);
            if(num<=median)
                maxHeap.add(num);
            else
                minHeap.add(num);
        }
    }
    public static void balance(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap)
    {
        if(minHeap.size()>maxHeap.size())// right side contains more value
            maxHeap.add(minHeap.poll());
        else if(maxHeap.size()-minHeap.size()>1)
            minHeap.add(maxHeap.poll());
        else
            return;
    }
    public static int findMedian(PriorityQueue<Integer> minHeap,PriorityQueue<Integer> maxHeap)
    {
        if(minHeap.size()==maxHeap.size())//even size total number
            return (minHeap.peek()+maxHeap.peek())/2;
        else
        {
            return maxHeap.peek();
        }
            
    }
    public static void getMedian(int num[])
    {
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>(num.length/2+2);
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(num.length/2+2,(a,b)->{
        	return b.intValue()-a.intValue();
        });
        for(int n:num)
        {
            add(n,minHeap,maxHeap);
            balance(minHeap,maxHeap);
            answer.append(findMedian(minHeap,maxHeap)+"\n");
        }
    }
	public static void main (String[] args)
	 {
	 //code
    	 int n=sc.nextInt();
    	 int num[]=new int[n];
    	 for(int i=0;i<n;i++)
    	    num[i]=sc.nextInt();
         getMedian(num);
    	 System.out.println(answer);
    	 sc.close();
	 }
}
