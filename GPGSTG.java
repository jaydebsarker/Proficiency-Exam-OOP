import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


class Vertex
{
	int val;
	String name;
	boolean visited=false;
	
	boolean bfs_visit=false;
	public Vertex() {
		this.name=null;
		this.visited=false;
		
		this.bfs_visit=false;
	}
	
	Vertex(int  n, String vname)
	{
		this.val=n;
		this.name=vname;
		this.visited=false;
	}
	
	
	// dfs visit 
	void visit()
	{
		visited=true;
	}
	
	//void visitbfs
	
	void visitbfs()
	{
		bfs_visit=true;
	}
	
	boolean isvisit()
	{
		return true;
	}
}

class GraphCreate
{
	Vertex vt;
	HashMap<Vertex, LinkedList<Vertex>> adjlist;
	GraphCreate()
	{
		adjlist=new HashMap<Vertex, LinkedList<Vertex>>();
	}
	
	void addedge(Vertex source, Vertex dest)
	{
		LinkedList<Vertex> okl=adjlist.get(source);
		if(okl!=null)
		{
			okl.remove(dest);
		}
		else
			okl=new LinkedList<Vertex>();
		okl.add(dest);
		adjlist.put(source,okl);
	}
	
	void print()
	{
		for(Vertex pd: adjlist.keySet())
		{
			System.out.println(" "+pd.name+" has edge with: ");
			for(Vertex nf: adjlist.get(pd))
			{
				System.out.print(" "+nf.name);
			}
			System.out.println();
		}
	}
	
	// dfs
	public void DFSmod(Vertex vx)
	{
		dfs(vx);
		
		for(Vertex k: adjlist.keySet())
		{
			if(!k.visited)
			{
				dfs(k);
			}
		}
	}
	
	public void dfs(Vertex vc)
	{
		vc.visit();
		
		System.out.println("Node name "+ vc.name);
		
		LinkedList<Vertex> op= adjlist.get(vc);
		if(op==null)
			return;
		
		for(Vertex cv: op)
		{
			if(!cv.visited)
			{
				dfs(cv);
			}
		}
	}
	
	//
	public void BFSsupp(Vertex c)
	{
		bfs(c);
		
		for(Vertex bf: adjlist.keySet())
		{
			if(!bf.bfs_visit)
			{
				bfs(bf);
			}
		}
	}
	
	public void bfs(Vertex bfsVert)
	{
		if(bfsVert==null)
			return;
		Queue<Vertex> que=new LinkedList<Vertex>();
		que.add(bfsVert);
		while(!que.isEmpty())
		{
			Vertex qt=que.poll();
			if(qt.bfs_visit)
			{
				continue;
			}
			qt.visitbfs();
			System.out.println(" Node is "+qt.name);
			
			LinkedList<Vertex> edge=adjlist.get(qt);
			
			if(edge==null)
				continue;
			for(Vertex nd: edge)
			{
				if(!nd.bfs_visit)
				{
					que.add(nd);
				}
			}
			System.out.println();
		}

	}
}


public class GPGSTG {
 public static void main(String args[])
 {
	 GraphCreate obj=new GraphCreate();
	 Vertex a1=new Vertex(1,"A");
	 Vertex a2=new Vertex(2,"B");
	 Vertex a3=new Vertex(3,"C");
	 Vertex a4=new Vertex(4,"D");
	 Vertex a5=new Vertex(5,"E");
	 
	 obj.addedge(a1, a2);
	 obj.addedge(a1, a3);
	 obj.addedge(a1, a4);
	 
	 obj.addedge(a2, a4);
	 obj.addedge(a3, a4);
	 obj.addedge(a4, a5);
	 
	 obj.print();
	 System.out.println("DFS search result is ");
	 obj.DFSmod(a1);
	 
	 System.out.println("BFS search result is ");
	 obj.BFSsupp(a1);
 }
}
