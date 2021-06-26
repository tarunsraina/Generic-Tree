package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveLeavesFromTree {
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
	
		Stack<Node> st=new Stack<>();
		int tree[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1};
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
		removeLeaves(root);
		LevelOrderTraversal(root);
		
	}

	private static void LevelOrderTraversal(Node node) {
	
		Queue<Node> queue1=new LinkedList<>();
		Queue<Node> queue2=new LinkedList<>();
		queue1.add(node);
		
		while(!queue1.isEmpty())
		{
			node=queue1.remove();
			System.out.print(node.data+" ");
			for(Node child:node.children)
			{
				queue2.add(child);
			}
			if(queue1.isEmpty())
			{
				queue1=queue2;
				queue2=new LinkedList<>();
				System.out.println();
			}
		}
		
	}
		
	private static void removeLeaves(Node node) {
		
	
		//if we traverse from left to right,logical error occurs
		//beacuse on deleting some elements,elements move one step left,and i increments
		//this will skip some elements,causing logical errors
		
		//so,traverse from right to left
		for(int i=node.children.size()-1;i>=0;i--)
		{
			Node child=node.children.get(i);
			if(child.children.size()==0)
			{
				node.children.remove(child);
			}
		}
		
		
		for(Node child:node.children)
		{
			removeLeaves(child);
		}
		

	}

}
