import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// this class is containing the left, right child and key value
class BSTNode
{
	//declare data 
	BSTNode left, right;  //node's right and left
	int data;   // data used as key value
	
	//initialize constructor
	
	public BSTNode()
	{
		left=null;
		right=null;
		data=0;
	}
	
	
	//initialize value
	public BSTNode(int n)
	{
		left=null;
		right=null;
		data=n;
	}
	
	// set to left node
	
	public void setLeft(BSTNode n)
	{
		left=n;
	}
	
	//get node left
	public BSTNode getLeft()
	{
		return left;
	}
	
	//set right node
	
	public void setRight(BSTNode n)
	{
		right=n;
	}
	
	// return right node
	
	
	public BSTNode getRight()
	{
		return right;
	}
	
	
	// set data node
	
	public void setData(int d)
	{
		data=d;
	}
	
	// get data
	
	public int getData()
	{
		return data;
	}
}


// binary search tree mechanism

class BinarySTree
{
	// root of the tree
	private BSTNode root; // only data field in tree
	
	
	public BinarySTree() {
		root=null;
	}
	
	// empty check of tree
	
	public boolean isEmpty()
	{
		return root==null;
	}
	
	// insert data
	
	public void insert(int data)
    {
        root = insert(root, data);
    }
	
	//insert recursively
	
	private BSTNode insert(BSTNode node, int data)
	{
		if(node==null)
			node=new BSTNode(data);
		
		else
		{
			if(data<=node.getData())
				node.left= insert(node.left, data);
			else
				node.right= insert(node.right, data);
		}
		return node;
	}
	
	// functions to search for an element
	
	public boolean find(int val)
	{
		return find(root, val);
	}
	
	// search in BSTNode
	public boolean find(BSTNode r, int key)
	{
		boolean found = false;
		
		while(r!=null && !found) 
		{
			int current= r.getData();
			if(key<current)
			{
				r= r.getLeft();
			}
			else if(key>current)
			{
				r=r.getRight();
			}
			
			else
			{
				found=true;
				break;
			}
		}
		
		return found;
	}
	
	// delete a node
	public void delete(int key)
	{
		delete(root, key);
	}
	
	
	// a recursive delete function
	private BSTNode delete(BSTNode r, int data)
	{
		// if tree is empty
		if(r==null)
			return r;
		
	    // otherwise down the tree
		if(data<r.data)
			r.left=delete(r.left, data);
		
		else if(data>r.data)
	        r.right= delete(r.right, data);	
			
	    // now, if the data is same as root then handle 3 cases
		
		else
		{
			//case 1: No child
			if(r.left==null && r.right==null)
			{
				r=null;
			}
			
			// no left child
			else if(r.left == null)
			{
				r=r.right;
				return r;
			}
			
			// no right child
			else if(r.right == null)
			{
				r=r.left;
				return r;
			}
			
			// if root has 2 children
			
			else
			{
				// max value of left subtree
				r.data= maxValue(r.left);
				
				// delete the inorder successor
				r.left= delete(r.left, r.data);
			}
		}
		return r;
	}
	
	
	// finding the min value function
	int maxValue(BSTNode r)
	{
		int min= r.data;
		
		while(r.right!=null)
		{
			min= r.right.data;
			r= r.right;
		}
		return min;
	}
	
	// inorder traversal

	public void inorder()
	{
		inorder(root);
	}
	

	private void inorder(BSTNode r)
	{
	   if(r!=null)
	   {
		   inorder(r.getLeft());
		   System.out.println(r.getData()+ " ");
		   inorder(r.getRight());
	   }
	}
	
	
	// preorder traversal
	
	public void preorder()
	{
		preorder(root);
	}
	
	private void preorder(BSTNode r)
	{
		if(r!=null)
		{
			System.out.println(r.getData()+ " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
		
	}
	
	// postorder traverse is
	
	public void postorder()
	{
		postorder(root);
	}
	
	private void postorder(BSTNode r)
	{
		if(r!=null)
		{
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.println(r.getData()+ " ");
		}
	}
}


public class BinarySearchTree {
  public static void main(String args[])
  {
	  BinarySTree bt= new BinarySTree();
	  
	  Scanner ip=new Scanner(System.in);
	  System.out.println("This is binary tree:");
	try {
		Scanner p = new Scanner(new File("C:\\Users\\gy3312\\BinarySearchTree\\src\\input.txt"));
		
		 while(p.hasNextInt())
		 {
			// System.out.println(p.nextInt());
			 bt.insert(p.nextInt()); 
		 }
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(" Could not open the file");
		e.printStackTrace();
	}
	  
	  System.out.println("Insert an element for delete");
	  bt.delete(ip.nextInt());
	  
	 
	  System.out.println("Inorder travese is");
	  bt.inorder();
	  
	 
	  System.out.println("Preorder traverse is");
	  bt.preorder();
	  
	  System.out.println("Postorder traverse is:");
	  bt.postorder();
	  
	  System.out.println("Find an element for search");
	  System.out.println(bt.find(ip.nextInt()));
	  
	  
	  
  }
  
}
