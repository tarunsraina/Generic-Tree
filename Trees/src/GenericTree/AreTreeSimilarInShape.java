package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class AreTreeSimilarInShape {
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}
	

	public static void main(String[] args) {
		
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<Node> st=new Stack<>();
		Node root=null;
		
		int arr2[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<Node> st2=new Stack<>();
		Node root2=null;
		
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
		
		
		for(int i=0;i<arr2.length;i++)
		{
			if(arr2[i]==-1)
			{
				st2.pop();
			}
			else
			{
				Node temp=new Node();
				temp.data=arr2[i];
				if(st2.size()>0)
				{
					st2.peek().children.add(temp);
				}
				else
				{
					root2=temp;
				}
				st2.push(temp);	
			}
		}
			System.out.println(areSimilar(root,root2));
	}


	private static boolean areSimilar(Node node1, Node node2) {
		
		if(node1.children.size()!=node2.children.size())
		{
			return false;
		}
		
		for(int i=0;i<node1.children.size();i++)
		{
			Node c1=node1.children.get(i);
			Node c2=node2.children.get(i);
			
			if(areSimilar(c1,c2)==false)
			{
				return false;
			}
			
		}
		return true;
	}

}

