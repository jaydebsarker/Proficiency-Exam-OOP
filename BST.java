import java.util.Scanner;



class Node
{
	Node left,right;
	int key;
	Node()
	{
		this.left=null;
		this.right=null;
		this.key=key;
	}
	
	Node(int n)
	{
		this.left=left;
		this.right=right;
		this.key=n;
	}
	
	void setData(int n)
	{
		key=n;
	}
	int getData()
	{
		return key;
	}
	
	void setLeft(Node nd)
	{
		left=nd;
	}
	
	Node getleft()
	{
		return left;
	}
	
	void setRight(Node nd)
	{
		right=nd;
	}
	
	Node getright()
	{
		return right;
	}
}

class BinarySearchTree
{
	private Node r;
	public BinarySearchTree() {
		
		r=null;
	}
	
	public boolean isEmpty()
	{
		return r==null;
	}
	
	void insert(int n)
	{
		r=insert(r,n);
	}
	
	Node insert(Node nd, int k)
	{
		if(nd==null)
			nd=new Node(k);
		else if(k<nd.key)
			nd.left = insert(nd.left,k);
		else 
			nd.right= insert(nd.right, k);
		
		return nd;
	}
	
	void delete(int n)
	{
		delete(r,n);
	}
    
	Node delete(Node nd, int n)
	{
		if(nd==null)
			return nd;
		if(n<nd.key)
			nd.left=delete(nd.left,n);
		
		else if(n>nd.key)
			nd.right=delete(nd.right, n);
		
		else
		{
			if(nd.left==null && nd.right==null)
			{
				nd=null;
				
			}
				
			else if(nd.left==null)
			{
				nd=nd.right;
			    return nd;
			}
				
			else if(nd.right==null)
			{
				nd=nd.left;
				return nd;
			}
			else
			{
				nd.key=maxLeft(nd.left);
				nd.left=delete(nd.left, nd.key);
			}
		}
		
		return nd;
	}
	
	int maxLeft(Node nd)
	{
		int m=nd.key;
		while(nd.right!=null)
		{
			m=nd.right.key;
			nd=nd.right;
		}
		return m;
	}
	public void inorder()
	{
		inorder(r);
	}
	
	
	
	void inorder(Node nd)
	{
		if(nd!=null)
		{
		inorder(nd.getleft());
		System.out.println(" "+nd.getData());
		inorder(nd.getright());
		}
	}
	
	boolean find(int n)
	{
		return find(r,n);
	}
	
	boolean find(Node nd, int k)
	{
		boolean tp=false;
		
		if(nd==null)
			return false;
		if(k==nd.key)
			return true;
		else if(k<nd.key)
			return find(nd.getleft(), k);
		else
			return find(nd.getright(),k);

	}
	
	void printrange(int n)
	{
		printrange(r,n);
	}
	
	void printrange(Node nd, int k)
	{
		if(nd==null)
			return;
		
		if(nd.key<=k)
		{
			printrange(nd.left, k);
			
		}
		if(nd.key<=k)
		{
			System.out.println(" "+nd.key);
		}
		
		if(k>nd.key)
		{
			printrange(nd.right,k);
		}
	}
	
	
	boolean path(int k)
	{
		boolean ll;
		ll=pathSum(r,k);
		return ll;
	}
	boolean pathSum(Node nd,int sum)
	{
		
		if(nd==null)
		{
			return false;
		}
		
		else
		{
			boolean ans=false;
			int subsum=sum-nd.getData();
			if(subsum==0 && nd.left==null && nd.right==null)
			{
				return true;
			}
			
			if(r.left!=null)
			{
				ans=ans||pathSum(nd.left, subsum);
			}
			if(r.right!=null)
			{
				ans=ans||pathSum(nd.right, subsum);
			}
			return ans;
		}
		
		
	}
}

public class BST {
   public static void main(String args[])
   {
	   BinarySearchTree obj=new BinarySearchTree();
	   Scanner sc=new Scanner(System.in);
	   int sz;
	   System.out.println("Enter the size");
	   sz=sc.nextInt();
	   System.out.println("Insert the number: ");
	   for(int i=1;i<=sz;i++)
	   {
		   int a;
		   a=sc.nextInt();
		   obj.insert(a);
	   }
	   
	   System.out.println("Inorder traverse is: ");
	   obj.inorder();
	   
	  /* System.out.println("Insert a value for find");
	   int f;
	   f=sc.nextInt();
	   
	   System.out.println("The found value: "+obj.find(f));
	   
	   System.out.println("Delete an object");
	   
	   int fnd;
	   fnd=sc.nextInt();
	   obj.delete(fnd);
	   
	   System.out.println("Inorder traverse is: ");
	   obj.inorder();
	   */
	   System.out.println("Enter a number to print which are less than that");
	   int rg;
	   rg=sc.nextInt();
	   obj.printrange(rg);
	   
	   System.out.println("Enter the sum to find (Exists or Not Exists)");
	   int has_sum;
	   has_sum=sc.nextInt();
	   
	   boolean tr=obj.path(has_sum);
	   
	   if(tr)
	   {
		   System.out.println("There is a path");
	   }
	   else
	   {
		   System.out.println("No path exists");
	   }
	 
   }
}
