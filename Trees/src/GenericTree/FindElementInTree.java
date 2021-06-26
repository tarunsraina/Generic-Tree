package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class FindElementInTree {
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		int tree[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<Node> st=new Stack<>();
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
		int ele=100;
		boolean bool=isElementPresent(root,ele);
		if(bool)
		{
			System.out.println(ele+" is present in the tree");
		}
		else
		{
			System.out.println(ele+" is not present in the tree");
		}
		
	}

	private static boolean isElementPresent(Node node,int ele) {
		
		if(node.data==ele)
		{
			return true;
		}
		else
		{
			
			for(Node child:node.children)
			{
				boolean bool=isElementPresent(child,ele);
				if(bool)
				{
					return true;
				}
			}
			return false;
			
		}
		
	}

}
