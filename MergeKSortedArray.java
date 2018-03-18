/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/
class GfG
     {
        public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
          {
              PriorityQueue<Integer> minHeap =new PriorityQueue<Integer>(k*k);
              for(int i=0;i<k;i++)
              {
                  for(int j=0;j<k;j++)
                    minHeap.add(arrays[i][j]);
              }
              ArrayList<Integer> sorted=new ArrayList<Integer>(k*k);
              while(!minHeap.isEmpty())
                sorted.add(minHeap.poll());
              return sorted;
          }
}
