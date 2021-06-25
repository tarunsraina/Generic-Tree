package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {
	
	
	/*
	 * 
	 * 
	 * 			
	 * 
	 *               Given tree:
                    
 								  10
                               /  |  \
  							  20  30  40
 								 /  \
  							    50  60
  							    
  							    
  							    
  					expected output:
  					
  								10
  								40 30 20
  								50 60
	 * 
	 * 	approach:
	 * 
	 * 		i)Take two stacks
	 * 		ii)push root to stack1 and its children to stack2
	 * 		iii)If the node is in odd level
	 * 						i)print the node
	 * 						ii)add children from left to right to stack2
	 * 						iii)pop the node
	 * 		iv)If the node is in even level
	 * 						i)print the node
	 * 						ii)add children from right to left to stack2
	 * 						iii)pop the node
	 * 
	 * 		v)If the stack1 is empty,
	 * 							copy stack2 to stack1
	 * 							make stack1 new
	 * 							level++
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static class Node
	{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		Node root=null;
		Stack<Node> st=new Stack<>();
		int tree[]= {10,20,-1,30,50,-1,60,-1,-1,40,-1};
		//int tree[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
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
		zigZagTraversal(root);
	}

	private static void zigZagTraversal(Node node) {
		
		
		Stack<Node> st1=new Stack<>();
		Stack<Node> st2=new Stack<>();
		
		st1.push(node);
		int level=1;
		
		while(!st1.isEmpty())
		{
			node=st1.pop();
			System.out.print(node.data+" ");
			
			if(level%2==1)
			{
				//left to right
				
				for(int i=0;i<node.children.size();i++)
				{
					Node child=node.children.get(i);
					st2.push(child);
				}
			}
			else
			{
				//right to left
				
				for(int i=node.children.size()-1;i>=0;i--)
				{
					Node child=node.children.get(i);
					st2.push(child);
				}
			}
			if(st1.isEmpty())
			{
				st1=st2;
				st2=new Stack<>();
				level++;
				System.out.println();
			}
		}

	}

}
