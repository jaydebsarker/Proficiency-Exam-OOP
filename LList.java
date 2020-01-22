import java.util.*;

class Node
{
	protected int data;
	protected Node next;
	
	public Node()
	{
		this.data= data;
	}
}

class SingleLList
{
	private Node head;
	
	public boolean Empty()
	{
		return (head==null);
	}
	
	public void insertBeforeHead(int data)
	{
		Node newNode=new Node();
		newNode.data = data;
		newNode.next=head;
		head=newNode;
	}
	
	public void insertafterTail(int data)
	{
		Node current=head; 
		while(current.next!=null)
		{
			current=current.next;
		}
		Node newNode=new Node();
		newNode.data= data;
		current.next=newNode;
		newNode.next=null;
	}
	
	public void insertatAnyPlace(Node np, Node jp)
	{
		Node current=head;
		Node first=null;
		while(current!=null && current.data!=jp.data)
		{
			first=current;
			current=current.next;
		}
		
		if(current!=null)
		{
			first.next=np;
			np.next=current;
		}
	}
	
	public void deleteFirst()
	{
		Node current= head;
		head= current.next;
	}
	// delete after a particular node
	
	public void deleteParticular(Node nd)
	{
		Node current= head;
		Node previous=null;
		// head is key
		if(current!=null && current.data==nd.data)
		{
			head= current.next;
		}
		
		// if other one is key

        while(current!=null && current.data!=nd.data)
        {
        	previous=current;
        	current=current.next;
        }
        if(current!=null)
        {
        	previous.next= current.next;
        }
        
	}
	public void showList()
	{
		Node current=head; 
		while(current!=null)
		{
			System.out.println(" "+current.data);
			current=current.next;
		}
	}
}

public class LList {
  public static void main(String args[])
{
      SingleLList obj= new SingleLList();

      Node nobj= new Node();
      Node obj1=new Node();
	  System.out.println("Insert data into list");
	  Scanner in= new Scanner(System.in);
	  
	int k=0;
	  while(k!=-1)
	  {
	  System.out.println("1: Show list"
	  		+ ", 2: Insert before head"
	  		+ " 3: Insert Last"
	  		+ "4: Delete first"
	  		+ " 5: Delete from other place"
	  		+ "6: Insert data between before a data");
	  int n=in.nextInt();
	  switch(n)
	  {
	  case 1:
		  System.out.println("Print the current LinkedList: ");
		  obj.showList();
		  break;
	  case 2:
		  System.out.println("Insert before head");
		  int da= in.nextInt();
		  obj.insertBeforeHead(da);
		  
		  System.out.println("Print the current LinkedList: ");
		  obj.showList();
		  break;
	  case 3: 
		  System.out.println("Insert data at last");
		  da= in.nextInt();
		  obj.insertafterTail(da);
		  
		  System.out.println("Print the current LinkedList: ");
		  obj.showList();
		  break;
	  
	  case 4:
		  System.out.println("Delete data first");
		  obj.deleteFirst();
		  
		  System.out.println("Print the current LinkedList: ");
		  obj.showList();
		  break;
	  case 5:
		  System.out.println("Delete data from other place: ");
		  System.out.println("Enter the data");
		  int ca= in.nextInt();
		  nobj.data=ca;
		  obj.deleteParticular(nobj);
		  
		  System.out.println("Print the current LinkedList: ");
		  obj.showList();
		  break;
	  case 6:
		  System.out.println("Insert data before a specific data: ");
		  System.out.println("Enter the data which you want to insert:");
		  ca= in.nextInt();
		  nobj.data=ca;
		  
		  System.out.println("Enter the data before which you want to insert");
		  da= in.nextInt();
		  obj1.data=da;
		  
		  obj.insertatAnyPlace(nobj, obj1);
		  
		  System.out.println("Print the current LinkedList: ");
		  obj.showList();
		  break;
	  }
	  }  


}
}
