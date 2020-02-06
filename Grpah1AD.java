import java.util.HashMap;
import java.util.LinkedList;

class Node
{
	int id;
	String name;
	Node(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
}

class GraphBuild
{
	HashMap<Node, LinkedList<Node>> adjc;
	
  GraphBuild() {
	          adjc= new HashMap<Node, LinkedList<Node>>();
               }	
  
  public void addEdge(Node source, Node Destination)
  {
	  LinkedList<Node> obj= adjc.get(source);
	  if(obj!=null)
	  {
		  obj.remove(Destination);
	  }
	  
	  else
		  
	  obj=new LinkedList<>();
	  obj.add(Destination);
	  
	  adjc.put(source,obj);
  }
  
  public void print()
  {
	  for(Node nd: adjc.keySet())
	  {
		  System.out.print("The adjacency of "+nd.name);
		  for(Node elem: adjc.get(nd))
		  {
			  System.out.print(" "+elem.name);
		  }
		  System.out.println();
	  }
  }
}


public class Grpah1AD {
  public static void main(String args[])
  {
	  GraphBuild object=new GraphBuild();
	  Node a=new Node(0, "A");
	  Node b=new Node(1, "B");
	  Node c= new Node(2,"C");
	  Node d=new Node(3,"D");
	  Node e=new Node(4,"E");
	  
	  object.addEdge(a, b);
	  object.addEdge(a, c);
	  
	  object.addEdge(c, b);
	  object.addEdge(d, e);
	  
	  object.print();
  }
}
