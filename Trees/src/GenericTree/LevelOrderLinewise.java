package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLinewise {
	
	/*
	 * 
	 * 
	 * 
	  				 Given tree:
                    
 								  10
                               /  |  \
  							  20  30  40
 								 /  \
  							    50  60
  							    
  							    
  							    
  					expected output:
  					
  								10
  								20 30 40
  								50 60
  								
  								
  		approach:
  			i)take two queues
  			ii)add parent to queue 1,add its children to queue2
  			iii)remove all and print from queue 1
  			iv)when queue1 is empty,swap queue1 with queue2 and continue the same.
  			
	 * 
	 */
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		Stack<Node> st=new Stack<>();
		int tree[]= {10,20,-1,30,50,-1,60,-1,-1,40,-1};
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

}
