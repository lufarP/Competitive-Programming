import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>
	{
		private int element;
		private int rowIndex;
		private int nextColumnIndex;
		public Node(int element,int rowIndex,int nextColumnIndex)
			{
				this.setElement(element);
				this.setRowIndex(rowIndex);
				this.setNextColumnIndex(nextColumnIndex);
				// TODO Auto-generated constructor stub
			}
		public int getElement()
			{
					return element;
			}
		private void setElement(int element)
			{
					this.element = element;
			}
		public int getRowIndex()
			{
					return rowIndex;	
			}
		private void setRowIndex(int rowIndex)
			{
					this.rowIndex = rowIndex;
			}
		public int getNextColumnIndex()
			{
					return nextColumnIndex;
			}
		private void setNextColumnIndex(int nextColumnIndex)
			{
					this.nextColumnIndex = nextColumnIndex;
			}
		@Override
		public int compareTo(Node that)
			{
				return this.element-that.element;
			}
		@Override
		public String toString()
		{
			return "[Element="+element+", RowIndex="+rowIndex+", NextColumnIndex"+nextColumnIndex+"]";
		}
		
	}
class SmallestRange
{
	public static int[] getSmallestRange(int[][]arr,int k)
	{
		PriorityQueue<Node> minHeap=new PriorityQueue<Node>(k);
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int minimalMax=max;
		int maximalMin=min;
		int minimumRange=Integer.MAX_VALUE;
		
		for(int i=0;i<k;i++)
			{
				minHeap.add(new Node(arr[i][0],i,1));
				if(max<arr[i][0])
					max=arr[i][0];
			}
		Node node=null;
		int row,column;
		while(true)
			{
				node=minHeap.poll();
				min=node.getElement();
				row=node.getRowIndex();
				column=node.getNextColumnIndex();
				if(max-min<minimumRange)
					{
						minimumRange=max-min;
						maximalMin=min;
						minimalMax=max;
					}
				if(column>=arr[row].length)
					break;
				else
					{
						
						node=new Node(arr[row][column], row, column+1);
						if(node.getElement()>max)
							max=node.getElement();
						minHeap.add(node);
					}
			}
		int answer[]= {maximalMin,minimalMax,minimumRange};

		return answer;
	}
	public static void main(String[] args)
		{
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			while(t-->0)
				{
					int n=sc.nextInt();
					int k=sc.nextInt();
					int arr[][]=new int[k][n];
					for(int i=0;i<k;i++)
						for(int j=0;j<n;j++)
							arr[i][j]=sc.nextInt();
					int answer[]=getSmallestRange(arr, k);
					System.out.println(answer[0]+" "+answer[1]);
				}

		    
		}
	
}
