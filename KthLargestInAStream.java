
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
class KthLargestInAStream
{
	static Scanner sc=new Scanner(System.in);
	static StringBuilder answer=new StringBuilder();
	public static void main (String[] args)
		{
			int t=sc.nextInt();
			PriorityQueue<Integer> minHeap;
			while(t-->0)
				{
					int k=sc.nextInt();
					minHeap=new PriorityQueue<Integer>();
					int n=sc.nextInt();
					for(int i=0;i<n;i++)
						{
							int item=sc.nextInt();
							if(minHeap.size()<k)
								minHeap.add(item);//adds value untill size equals to k
							else if(minHeap.size()==k)
								{
									if(item>minHeap.peek())
										{
											/*
											 * item input is greater than kth largest value 
											 * then kth largest value will change
											 * therefore find the new kth largest value
											 */
											minHeap.poll();
											minHeap.add(item);
										}
									
								}
							
							if(minHeap.size()<k)
								answer.append("-1 ");
							else
								answer.append(minHeap.peek()+" ");
						}
					answer.append("\n");
					minHeap.clear();
				}
			System.out.println(answer);
			sc.close();
		}
}
