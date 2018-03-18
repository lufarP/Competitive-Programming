/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the code*/
class KthSmallest
{
	public static void kthSmallest(int[][] a,int n,int k)
	{
	    PriorityQueue<Integer>maxHeap=new PriorityQueue<Integer>(k,(c,b)->
	    {
	        return b-c;
	    });
	    int i,j;
	    for( i=0;i<n;i++)
	    {
	        for( j=0;j<n;j++)
	        {
	            if(maxHeap.size()<k)
	                maxHeap.add(a[i][j]);
                else
                {
                    if(maxHeap.peek()<a[i][j])
                        continue;
                    else
                    {
                        maxHeap.poll();
                        maxHeap.add(a[i][j]);
                    }
                }
	                
	        }
	    }
	    System.out.println(maxHeap.peek());
	    
	    
	}
}
