package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class PredecessorAndSuccessor {
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}
	
	
	static Node pd=null;
	static Node sc=null;
	static int state=0;
	public static void main(String[] args) {
		
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<Node> st=new Stack<>();
		Node root=null;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==-1)
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
		
		predecessorAndSuccessor(root,100);

		
	}
	private static void predecessorAndSuccessor(Node root,int data) {
		
		if(state==0)
		{
			if(root.data==data)
			{
				state=1;
			}
			else
			{
				pd=root;
			}
		}
		else if(state==1)
		{
			sc=root;
			state=2;
		}
		
		for(Node child:root.children)
		{
			predecessorAndSuccessor(child,data);
		}
	}

}
