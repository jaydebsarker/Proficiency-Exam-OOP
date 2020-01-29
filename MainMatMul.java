
import java.io.*;
import java.util.Scanner;
class Mat
{
	int matM[][];
	int row,col;
	
	Mat( int row, int col)
	{
		row=this.row;
		col=this.col;
		matM=new int[row][col];
	}
	
	int[][] getArr(int m, int n)
	{
		Scanner a=new Scanner(System.in);
		
		int m1[][]=new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int val=a.nextInt();
				m1[i][j]= val;
			}
		}
		
		return m1;
	}
	
	public void printArr(int m1[][])
	{
		int m=m1.length;
		 int n=m1[0].length;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(" "+m1[i][j]);
			}
			System.out.println();
		}
	}
	
	
	int[][] addMat(int m1[][], int m2[][], int p, int q)
	{
		int sum[][]= new int[10][10];
		
		for(int i=0;i<p;i++)
		{
			for(int j=0;j<q;j++)
			{
				sum[i][j]= m1[i][j]+m2[i][j];
			}
		}
		return sum;
	}
	
	int [][] multMat(int m1[][], int m2[][])
	{
		int r1=m1.length;
		int c1=m1[0].length;
		int r2=m2.length;
		int c2=m2[0].length;
		
		if(c1!=r2)
		{

		}
		
		int mult[][]= new int[r1][c2];
		for(int i=0;i<r1;i++)
		{
			for(int j=0;j<c2;j++)
			{
				mult[i][j]=0;
				for(int k=0;k<c1;k++)
				{
					
					mult[i][j]+=m1[i][k]*m2[k][j];
				}
			}
		}
		
		
		return mult;
	}
	
	int [][] trans(int m1[][])
	{
		int r1=m1.length;
		int c1= m1[0].length;
		
		int tpm[][]=new int[c1][r1];
		
		for(int i=0;i<c1;i++)
		{
			for(int j=0;j<r1;j++)
			{
				tpm[i][j]=m1[j][i];
			}
		}
		
	   return tpm;
	}
}


public class MainMatMul {
 public static void main(String args[])
 {
	 Mat obj=new Mat(2,2);
	 
	 int mm1[][]=new int[2][2];
	 int mm2[][]=new int[2][2];
	 int sumarr[][]=new int[2][2];
	 
	 int mm3[][]=new int[3][2];
	 int trans[][]= new int[10][10];
	 mm1=obj.getArr(2, 2);
	 mm2=obj.getArr(2, 2);
	 mm3=obj.getArr(3, 2);
	 
	 sumarr=obj.multMat(mm1, mm2);
	 
	 trans=obj.trans(mm3);
	 obj.printArr(trans);
	
 }
}
