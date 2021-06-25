package GenericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import GenericTree.LevelOrderLinewise.Node;

public class MirrorOfATree {
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
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
					st.peek().children.add(temp);
				}
				else
				{
					root=temp;
				}
				st.push(temp);
			}
		}
		System.out.println("Initial:");
		levelOrderTraversalLinewise(root);
		System.out.println("After Mirroring:");
		mirrorOfTree(root);
		levelOrderTraversalLinewise(root);
		
	}

private static void levelOrderTraversalLinewise(Node node) {
		
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


	private static void mirrorOfTree(Node root) {
		
		for(Node child:root.children)
		{
			mirrorOfTree(child);
		}
		Collections.reverse(root.children);
	}
	

}
