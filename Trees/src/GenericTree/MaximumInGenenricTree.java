package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumInGenenricTree {
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		Node root=null;
		Stack<Node> st=new Stack<>();
		
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==1)
			{
				st.pop();
			}
			else
			{
				Node temp=new Node();
				temp.data=arr[i];
				if(st.size()>0)
				{
					st.peek().children.add(temp);
				}
				else
				{
					root=temp;
				}
				st.push(temp);
			}
		}
		int max=max(root);
		System.out.println(max);
		
	}

	private static int max(Node root) {
		
		int max=Integer.MIN_VALUE; //lowest possible value(-infinity)->identity for maximum
		//int max=-2;
		for(Node child:root.children)
		{
			int childMax=max(child);
			if(childMax>max)
			{
				max=childMax;
			}
			
		}
		
		//all childs are compared above,now compare with the root node.
		if(root.data>max)
		{
			return root.data;
		}
		else
		{
			return max;
		}
	}

}
