package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeImplementation {
	
	public static class Node{
		int data;
		ArrayList<Node> childern=new ArrayList<>();
	}
	

	public static void main(String[] args) {
		
		int arr[]= {10,20,-1,30,40,-1,-1,60};
		//above array should be constructed using euler graph/tree
		
		Node root = null;
		Stack<Node> st=new Stack<>();
		for(int i=0;i<arr.length;i++)
		{
			
			if(arr[i]==-1)
			{
				if(!st.isEmpty())
				{
					st.pop();
				}
			}
			else
			{
				Node temp=new Node();
				temp.data=arr[i];
				if(st.size()>0)
				{
					st.peek().childern.add(temp);
				}
				else
				{
					root=temp;
				}
				st.push(temp);
			}
		}
		System.out.println(root.data);
	}
	

}
