package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTreeTraversalWithPointer {
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		Node root=null;
		Stack<Node> st=new Stack<>();
		int tree[]= {10,20,-1,30,50,-1,60,-1,-1,40,-1};
		
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
		Traversal(root);

}

	private static void Traversal(Node node) {
		
		Queue<Node> queue=new LinkedList<>();
		queue.add(node);
		queue.add(null);
		
		while(!queue.isEmpty())
		{
			node=queue.remove();
			if(node!=null)
			{
				System.out.print(node.data+" ");
				for(Node child:node.children)
				{
					queue.add(child);
				}
			}
			else
			{
				if(queue.size()>0)
				{
					queue.add(null);
					System.out.println();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}