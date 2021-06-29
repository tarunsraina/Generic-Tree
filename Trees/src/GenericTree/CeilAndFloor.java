package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CeilAndFloor {
	
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
		int data=100;
		findCeilAndFloor(root,data);
		System.out.println("ceil of "+data+" is "+ceil);
		System.out.println("floor of "+data+" is "+floor);

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
