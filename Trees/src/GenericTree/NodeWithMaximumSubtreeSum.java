package GenericTree;

public class NodeWithMaximumSubtreeSum {
	
	
	
	static int NodeWithMaxSum=0;
	static int maxSum=Integer.MIN_VALUE;
	
	public static class Node{
		int data;
		java.util.ArrayList<Node> children=new java.util.ArrayList<>();
	}

	public static void main(String[] args) {
	
		java.util.Stack<Node> st=new java.util.Stack<>();
		int tree[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
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
		
		int subtreeSum=nodeWithMaxSubtreeSum(root);
		System.out.println("The Node with maximum subtree sum is "+NodeWithMaxSum);
		System.out.println("Its sum is:"+subtreeSum);
		
	}

	private static int nodeWithMaxSubtreeSum(Node root) {
		
		int sum=0;
		for(Node child:root.children)
		{
			int childSum=nodeWithMaxSubtreeSum(child);
			sum+=childSum;
			
		}
		sum+=root.data;
		
		if(sum>maxSum)
		{
			NodeWithMaxSum=root.data;
			maxSum=sum;
		}
		
		return sum;
		
	}
	
 

}
