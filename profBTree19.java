import java.util.LinkedList;
import java.util.Queue;

class TreeNode
{
	int val;
	TreeNode left=null;
	TreeNode right=null;
	public TreeNode(int x) {
		//this.left=null;
		//this.right=null;
		this.val=x;
	}
}

class solution
{
	TreeNode r;
	 void str2tee(String s)
	{
		r=str2tree(s);
	}
	
	public TreeNode str2tree(String s) {
		
		if (s.length() == 0) 
	    	return null;
		int i=0,j=0;
	    
	    int n=0;
	  
	    while(i<s.length() && Character.isDigit(s.charAt(i)))
	    {
	    	n=n*10+(s.charAt(i)-'0');
	    	i++;
	    }
	    
	    TreeNode curr=new TreeNode(n);
	    
	    // left child
	    if(i<s.length())
	    {
	    	j=i;
	    	int cn=1;
	    	while(i+1<s.length() && cn!=0)
	    	{
	    		i++;
	    		if(s.charAt(i)=='(')
	    			cn++;
	    		if(s.charAt(i)==')')
	    			cn--;
	    	}
	    	curr.left=str2tree(s.substring(j+1,i));
	    }
	     i++;
	    if(i<s.length())
	    {
	    	curr.right=str2tree(s.substring(i+1,s.length()-1));
	    }
	    return curr;
	}
	
	void preorder()
	{
		preorder(r);
	}
	
	void preorder(TreeNode n)
	{
		if(n!=null)
		{
			System.out.println(" "+n.val);
			preorder(n.left);
		
			preorder(n.right);
			
		}
		
	}
	
	void bfs()
	{
		BreathFS(r);
	}
	
	public void BreathFS(TreeNode nd)
	{
		if(nd==null)
			return;
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		qu.add(r);
		
		while(!qu.isEmpty())
		{
			TreeNode nk=qu.poll();
			System.out.println(" "+nk.val);
			if(nk.left!=null)
			{
				qu.add(nk.left);
			}
			if(nk.right!=null)
			{
				qu.add(nk.right);
			}
		}
	}
}
public class profBTree19 {
  public static void main(String args[])
  {
	  String st="40(2(3)(1))(6(5))";
	  solution obj;
	  obj=new solution();
	  obj.str2tee(st);
	  
      //obj.preorder();
	  obj.bfs();
     
  }
}
