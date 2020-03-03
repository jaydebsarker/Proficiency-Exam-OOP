import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Set
{
	String[] union(String a[], String b[])
	{
		String[] u= {};
		HashSet<String> hs=new HashSet<String>();
		
		hs.addAll(Arrays.asList(a));
		hs.addAll(Arrays.asList(b));
		
		//System.out.println(hs);
		
		u=hs.toArray(u);
		
		
		return u;
	}
}


public class SetMain {
 public static void main(String args[]) 
 {
	 String A[]= {"A", "B", "C", "D"};
	 String B[]= {"A", "B"};
	 String C[];
	 Set obj=new Set();
	 C=obj.union(A, B);
	 System.out.println(Arrays.toString(C));
	 //Scanner sc=new Scanner(System.in);
	 //A=sc.nextLine();
	 
 }    
}
