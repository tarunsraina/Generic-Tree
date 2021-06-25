package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class HeightOfATree {
	
	static boolean RoothasChild=false;
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		Node root=null;
		//int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		//int arr[]= {10,20,-1,30,-1};
		int arr[]= {10,-1};
		Stack<Node> st=new Stack<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==-1)
			{
				st.pop();
			}
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
		int Edgeheight=Edgeheight(root);
		System.out.println("Edge Height:"+Edgeheight);
		int Nodeheight=Nodeheight(root);
		System.out.println("Node Height:"+(Nodeheight));
		
	}

	private static int Edgeheight(Node root) {
			int height=-1;
			for(Node child:root.children)
			{
				RoothasChild=true;
				height++;
				int childheight=Edgeheight(child);
				height=Math.max(childheight, height);
			}
			if(RoothasChild==false)
			{
				return 0;
			}
			return height;
		}

	private static int Nodeheight(Node root) {
		int height=0;
		for(Node child:root.children)
		{
			height++;
			int childheight=Nodeheight(child);
			height=Math.max(childheight, height);
		}
		if(RoothasChild==false)
		{
			return 1;
		}
		return height;
	}
}

	