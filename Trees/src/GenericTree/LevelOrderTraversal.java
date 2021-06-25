package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	  				 Given tree:
                    
 								  10
                               /  |  \
  							  20  30  40
 								 /  \
  							    50  60
	 * 
	 * 		int tree[]= {10,20,-1,30,50,-1,60,-1,-1,40,-1};
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 	 approach:Remove-print-add[RPA]     
	 * 
	 * 	 using queue FIFO property,
	 * 
	 * 	 print 10  queue=[10]
	 * 
	 * 	 remove 10,then print 10,then add its child[20,30,40] // print-10  ,queue=[20,30,40] 10 removed
	 * 
	 * 	 now remove 20,print 20,add its child[none for 20]    // print-10 20 ,queue=[30,40]  20 removed
	 * 
	 * 	 now remove 30,print 30,add its child[50,60] // print-10 20 30 , queue=[40,50,60] 30 removed
	 * 
	 * 	 now remove 40,print 40,add its child[none for 40] //print-10 20 30 40 , queue=[50,60] 40 removed
	 * 
	 * 	 now remove 50,print 50,add its child[none for 50] //print-10 20 30 40 50, queue=[60]  50 removed
	 * 
	 * 	 now remove 60,print 60,add its child[none for 60] //print-10 20 30 40 50 60,queue=[]  60 removed
	 * 
	 *   since queue is empty,come out of the loop and print out to the console
	 *   
	 *   output:   10 20 30 40 50 60
	 *
	 * 
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
		levelOrderTraversal(root);
	}

	private static void levelOrderTraversal(Node node) {
		
		Queue<Node> queue=new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty())
		{
			node=queue.remove();
			System.out.print(node.data+" ");
			
			for(Node child:node.children)
			{
				queue.add(child);
			}
		}
	}

}
