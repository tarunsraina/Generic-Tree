package GenericTree;

import java.util.ArrayList;
import java.util.Stack;



public class LinearizeTree {

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
				linearizeTree(root);
	}

		private static void linearizeTree(Node node) {
			
			for(Node child:node.children)
			{
				linearizeTree(child);
			}
			
			while(node.children.size()>1)
			{
				Node Last=node.children.remove(node.children.size()-1);
				Node SecondLast=node.children.get(node.children.size()-1);
				Node SecondLastTail=getTail(SecondLast);
				SecondLastTail.children.add(Last);
				
			}
		}

		private static Node getTail(Node node) {
			while(node.children.size()==1)
			{
				node=node.children.get(0);
			}
			return node;
		}

}
