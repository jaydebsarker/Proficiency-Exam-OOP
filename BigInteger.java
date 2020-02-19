class data
{
	private String first;
	private String second;

	data(String first, String second)
	{
	   this.first= first;
	}
	
	static String sum(String first, String second)
	{
		// make sure about the string length
		if(first.length()>second.length())
		{
			String s1= first;
			first=second;
			second=s1;
		}
		
		String summation= " ";
		int l1, l2;
		l1=first.length();
		l2=second.length();
		
		int diff=l2-l1;
		
		int carry=0;
		int sum_num=0;
		
		// add from reverse order
		for(int i=l1-1;i>=0;i--)
		{
			sum_num= (int)(first.charAt(i)-'0')+ (int) (second.charAt(i+diff)- '0')+ carry;
			summation+= (char)(sum_num%10+ '0');
			carry= sum_num/10;
		}
		
		// add extra characters
		for(int j=l2-l1-1;j>=0;j--)
		{
			sum_num= (int)(second.charAt(j)-'0')+carry;
			summation+= (char)(sum_num%10+ '0');
			carry= sum_num/10;
		}
		
		if(carry>1)
		{
			summation+= (char)(carry+ '0');
		}
		return new StringBuilder(summation).reverse().toString();
	}
	
	static String mult(String first, String second)
	{
		int l1, l2;
		l1=first.length();
		l2=second.length();
		int mult_both[]=new int[l1+l2];
		int diff=l2-l1;
		if(l1==0||l2==0)
		{
			return "0";
		}
		
		
		return first;
	}
	
}


public class BigInteger {
	public static void main(String args[])
	{
		String a= "5555";
		String b= "3333";
		data obj= new data(a,b);
		System.out.println(obj.sum(a,b));
		System.out.println(obj.mult(a,b));
		
		
	}

}
