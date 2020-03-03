import javax.swing.tree.TreeNode;

class ListNode
{
	ListNode left;
	ListNode right;
	int data;
	
	public ListNode(int n) {
		this.left=null;
		this.right=null;
		this.data=n;
	}
	
}

class DoubleLink
{
	private ListNode head=null;
	private ListNode tail=null;
	
	public boolean isEmpty()
	{
		return (head==null);
	}
	
	// insert data
	void insert(int n)
	{
		ListNode newNode=new ListNode(n);
		
		if(isEmpty())
		{
			head=tail=newNode;
			head.left=null;
			tail.right=null;
		}
		else
		{
			tail.right=newNode;
			newNode.left=tail;
			tail=newNode;
			tail.right=null;
		}
	}
	
	// insert between two elements
	void insert_after_element(int k,int n)
	{
		
		ListNode curr=head;
		ListNode ft=null;
		ListNode pk=null;
		
		while(curr!=null && curr.data!=k)
		{
			pk=curr;
			curr=curr.right;
			
		}
		System.out.println("PK data is "+pk.data);
		
		if(curr!=null)
		{
			ListNode newNd=new ListNode(n);
			ft=curr.right;
			ft.left=curr;
			
			curr.right=newNd;
			newNd.left=curr;
			newNd.right=ft;
			ft.left=newNd;
		}
		else
		{
			System.out.println("Data not found");
		}
		
	}
	
	// delete after an element
	
	void delete_double(int key)
	{
		ListNode curr=head;
		if(curr==null)
		{
			System.out.println("List is empty");
		}
		else
		{
			ListNode pl=null;
			ListNode ck=null;
			
			while(curr!=null && curr.data!=key)
			{
				pl=curr;
				curr=curr.right;
			}
			
			if(curr!=null)
			{
				ck=curr.right;
				
				pl.right=ck;
				ck.left=curr.left;
				
				curr.right=null;
				curr.left=null;
				curr=null;
			}
		}
	}
	
	//print
	void print()
	{
		ListNode nd=head;
		if(isEmpty())
		{
			System.out.println("The list is empty");
		}
		while(nd!=null)
		{
			System.out.println(" "+nd.data);
			nd=nd.right;
		}
	}
}

public class DoublyLinkList {
  public static void main(String args[])
  {
	DoubleLink obj=new DoubleLink();
	obj.insert(10);
	obj.insert(7);
	obj.insert(3);
	obj.insert(9);
	obj.insert_after_element(13, 8);
	obj.insert_after_element(3, 8);
	
	
	//obj.print();
	
	obj.delete_double(8);
	obj.print();
  }
}
