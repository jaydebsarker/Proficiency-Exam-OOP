import java.util.Scanner;

class MaxHeap
{
	int heaparr[];
	int size;
	int maxim;
	
	MaxHeap(int nx)
	{
		this.size=0;
		this.maxim=nx;
		heaparr=new int[maxim];
		heaparr[0]=Integer.MAX_VALUE;
	}
	
	int parent(int index)
	{
		return (index/2);
	}
	
	int left_child(int index)
	{
		return (2*index);
	}
	
	int right_child(int index)
	{
		return (2*index+1);
	}
	
	boolean isLeaf(int index)
	{
		if(index>=(size/2) && index<size)
		{
			return true;
		}
		return false;
	}
	
	
	
	void maxHeapify(int index, int sz)
	{
		int l,r;
	
		int large=index;
		l=left_child(index);
		r=right_child(index);
		
		
		if(isLeaf(index))
		{
			return;
		}
		
		if(l<sz && heaparr[l]>heaparr[index])
		{
			large=l;
		}
		
		if(r<sz && heaparr[r]>heaparr[large])
		{
			large=r;
		}
		
		
		if(large!=index)
		{
			swap(index, large);
			maxHeapify(large,sz);
		}
		
	}
	
	void swap(int first, int second)
	{
		int t;
		t=heaparr[first];
		heaparr[first]=heaparr[second];
		heaparr[second]=t;	
	}
	
	void insert(int val)
	{
		heaparr[++size]=val;
		int cr= size;
		
		while(heaparr[cr]>heaparr[parent(cr)])
		{
			swap(cr,parent(cr));
			cr=parent(cr);
		}
	}
	
	void delete(int d_val)
	{
		int ind;
		for(ind=1; ind<=size; ind++)
		{
			if(heaparr[ind]==d_val)
				break;
		}
		
		if(d_val!=heaparr[ind])
		{
			System.out.println("There is no value in the heap");
			return;
		}
		
		heaparr[ind]=heaparr[size];
		size--;
		maxHeapify(ind,size);
		
	}
	
	void heapsor()
	{
		int n=size;
		int i;
		
		for(i=size;i>=1;i--)
		{
			swap(1,i);
			
			System.out.println("Value of i " +i);
			maxHeapify(1,i);
			show();
		}
	}
	
	void show()
	{
		int i;
		System.out.println("Show the array");
		for(i=1;i<=size;i++)
		{
			System.out.print(" "+heaparr[i]);
		}
		System.out.println("");
	}
}



public class maxHeapbuilt {
 public static void main(String args[])
   {
	MaxHeap mx=new MaxHeap(12);
	int a,cnt=0;
	Scanner obj=new Scanner(System.in);
	System.out.println("Enter value to insert the Heap: ");
    // insert the elements
	while(cnt<=9)
	{
		cnt++;
		a=obj.nextInt();
		mx.insert(a);
		
	}
	mx.show();
	// delete specific elements
	System.out.println("Enter the element for deleting");
	int b=obj.nextInt();
	mx.delete(b);
	mx.show();
	
	System.out.println("The sorted array is: ");
	mx.heapsor();
	mx.show();
   }
}
