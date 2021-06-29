package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

/*Maximum # of edges between any two nodes is considered as diameter*/

/*calculating diameter,but in recursive call we return height(calculate something,return something)
 * 
 * we need diameter(declare as static),so we are calculating diameter,but in recursive call we are returning height
 * to get the deepest and second deepest childs in a tree.
 */


public class DiameterOfGenericTree {
	
	static int dia=0;
	
	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
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
			diameterOftree(root); //even though it returns height,we dont need that
			System.out.println(dia);
			
	}

	private static int diameterOftree(Node node) {
		
		int deepestHeight=-1;
		int secondDeepestHeight=-1;
		for(Node child:node.children)
		{
			int childHeight=diameterOftree(child);
			
			if(childHeight>deepestHeight)
			{
				secondDeepestHeight=deepestHeight;
				deepestHeight=childHeight;
			}
			else if(childHeight>secondDeepestHeight)
			{
				secondDeepestHeight=childHeight;
			}
		}
		
		if(deepestHeight+secondDeepestHeight+2>dia)
		{
			dia=deepestHeight+secondDeepestHeight+2;
		}
		
		deepestHeight+=1;
		return deepestHeight;
	}

}
