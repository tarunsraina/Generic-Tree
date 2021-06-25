
package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class SizeOfGenericTree {
	
	static int count=0;
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}
	
	
	public static int size(Node node)
	{
		
		for(Node child:node.children)
		{
			count++;
			size(child);
		}
		return count+1; //count calculates all childs,but not the root,so add 1
	}

	public static void main(String[] args) {
		
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		//above array used euler tree concept
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
		//System.out.println(root.data);
		int size=size(root);
		System.out.println(size);

	}

}
