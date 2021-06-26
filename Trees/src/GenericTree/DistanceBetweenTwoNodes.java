package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.Node;

public class DistanceBetweenTwoNodes {

	public static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	public static void main(String[] args) {
		
		int tree[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Stack<Node> st=new Stack<>();
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
			int data1=100;
			int data2=110;
			System.out.println("Distance between "+data1+ " and "+data2+" is "+distance(root,10,60));
	}

	private static int distance(Node node, int d1, int d2) {
		
		ArrayList<Integer> p1=nodeToRootPath(node,d1);
		ArrayList<Integer> p2=nodeToRootPath(node,d2);
		
		int i=p1.size()-1;
		int j=p2.size()-1;
		
		while(i>=0 && j>=0 && p1.get(i)==p2.get(j))
		{
			i--;
			j--;
			
		}
		j++;
		i++;
		
		return i+j;
		
	}

	private static ArrayList<Integer> nodeToRootPath(Node node, int ele) {
		
		if(node.data==ele)
		{
			ArrayList<Integer> al=new ArrayList<>();
			al.add(node.data);
			return al;
		}
		for(Node child:node.children)
		{
			ArrayList<Integer> pathTillChild=nodeToRootPath(child,ele);
			if(pathTillChild.size()>0)
			{
				pathTillChild.add(node.data);
				return pathTillChild;
			}
		}
		return new ArrayList<>();
	}

}
