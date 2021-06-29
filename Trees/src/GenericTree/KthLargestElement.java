package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class KthLargestElement {
	
	static int ceil;
	static int floor;
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Stack<Node> st=new Stack<>();
		int tree[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=null;
		for(int i=0;i<tree.length;i++)
		{
			if(tree[i]==-1)
			{
				st.pop();
			}
			else
			{
				Node temp=new Node();
				temp.data=tree[i];
				if(st.isEmpty())
				{
					root=temp;
				}
				else
				{
					st.peek().children.add(temp);
				}
				st.push(temp);
			}
				
		}
		
		ceil=Integer.MAX_VALUE;  //smallest among larger
		floor=Integer.MIN_VALUE; //largest among smaller
		int k=4;
		int res=kthLargest(root,k);
		System.out.println(res);
	
	}

	private static int kthLargest(Node root, int k) {

		floor=Integer.MIN_VALUE;
		int factor=Integer.MAX_VALUE;
		for(int i=0;i<k;i++)
		{
			findCeilAndFloor(root,factor);
			factor=floor;
			floor=Integer.MIN_VALUE;
		}
		return factor;
	}

	private static void findCeilAndFloor(Node root, int data) {
	
		if(root.data>data)
		{
			if(root.data<ceil)
			{
				ceil=root.data;  //keep updating ceil
			}
		}
		if(root.data<data)
		{
			if(root.data>floor)
			{
				floor=root.data;  //keep updating floor
			}
		}
		
		for(Node child:root.children)
		{
			findCeilAndFloor(child,data);
		}
		
	}

}
