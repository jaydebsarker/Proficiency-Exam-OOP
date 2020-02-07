import java.util.HashMap;
import java.util.LinkedList;

class Vertex
{
	int id;
	String name;
	boolean visited;
	Vertex(int id, String name)
	{
		this.id=id;
		this.name=name;
		visited=false;
	}
	
	void visit()
	{
		visited=true;
	}
	
	void univisit()
	{
		visited=false;
	}
	
	boolean isvisited()
	{
		return true;
	}
}

class GraphStructure
{
	Vertex nd;
	HashMap<Vertex, LinkedList<Vertex>> adjlist;
	boolean directed;
	public GraphStructure(boolean directed)
	{
		this.directed=true;
		adjlist=new HashMap<Vertex, LinkedList<Vertex>>();
	}
	
	public void addedge(Vertex source, Vertex destination)
	{
		LinkedList<Vertex> objc= adjlist.get(source);
		
		if(objc!=null)
		{
			objc.remove(destination);
		}
		else
			 objc=new LinkedList<Vertex>();
		     objc.add(destination);
		     adjlist.put(source, objc); 
	}
	
	public void printedges()
	{
		for(Vertex nd: adjlist.keySet())
		{
			System.out.print("The edges of "+nd.name);
			for(Vertex ng: adjlist.get(nd))
			{
				System.out.print(" "+ng.name);
			}
			System.out.println();
		}
	}
	
	
	public void dfsmod(Vertex nbd)
	{
		dfs(nbd);
		
		for(Vertex n: adjlist.keySet())
		{
			if(!n.visited)
			{
				dfs(n);
			}
		}
	}
	
	public void dfs(Vertex n)
	{
		n.visit();
		System.out.println(" Node name "+n.id);
		
		LinkedList<Vertex> obj=adjlist.get(n);
		
		if(obj== null)
			return;
		
		for(Vertex nd: obj)
		{
			if(!nd.visited)
			{
				dfs(nd);
			}
		}
		
	}
}


public class GraphShowDfs {
  public static void main(String args[])
  {
	  GraphStructure gph= new GraphStructure(true);
	  Vertex a=new Vertex(0, "A");
	  Vertex b=new Vertex(1, "B");
	  Vertex c=new Vertex(2, "C");
	  Vertex d=new Vertex(3, "D");
	  Vertex e=new Vertex(4, "E");
	  Vertex f=new Vertex(5, "F");
	  Vertex g=new Vertex(6, "G");
	  Vertex h=new Vertex(7, "H");
	  Vertex i=new Vertex(8, "I");
	  
	  
	  gph.addedge(b, a);
	  gph.addedge(d, b);
	  gph.addedge(c, h);
	  gph.addedge(f, c);
	  
	  gph.addedge(f, a);
	  gph.addedge(f, c);
	  gph.addedge(g, f);
	  gph.addedge(g, d);
	  
	  gph.addedge(h, f);
	  gph.addedge(h, g);
	  gph.addedge(h, i);
	  
	  gph.printedges();
	  
	  //gph.dfs(a);
	  
	  gph.dfsmod(h);
  }
}
