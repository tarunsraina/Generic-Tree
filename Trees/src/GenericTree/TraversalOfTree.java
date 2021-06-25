package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

/*
 *                   Given tree:
 *                   
 * 								 10
 *                            /  |  \
 * 							20   30  40
 * 								/  \
 * 							   50  60
 * 
 * 
 * 			preorder will be:  10 20 30 50 60 40
 * 
 * 
 * preorder:
 *   
 *   	euler path -> Node's left side  [like usual]
 * 		[before going deep in recursion] so, "write code before recursive call"
 * 		Root first. [root-left-right]
 *
 * postorder:
 * 
 * 		euler path -> Node's right side
 * 		[while coming out of recursion] so, "write code after recursive call"
 * 		Root last.[left-right-root]
 * 
 * 
 * 
 * 
 */

public class TraversalOfTree {
	
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
		System.out.println("Pre-order traversal:");
		preOrdertraversal(root);
		System.out.println();
		System.out.println("Post-order traversal:");
		postOrdertraversal(root);

	}


	private static void preOrdertraversal(Node root) {
		
		System.out.print(root.data+" ");
		for(Node child:root.children)
		{
			preOrdertraversal(child);
		}
		
	}
	
	private static void postOrdertraversal(Node root) {
			
			for(Node child:root.children)
			{
				postOrdertraversal(child);
			}
			System.out.print(root.data+" ");
		}

}
