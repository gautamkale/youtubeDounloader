import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Bubblesort {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] a = new int[20];
		int i,j,temp = 0,k,pass;
		System.out.println("Enter the no.");
		BufferedReader reade=new BufferedReader(new  InputStreamReader(System.in));
		int n=Integer.parseInt((reade.readLine()));
		System.out.println("inte array element");
		for(i=0;i<n;i++)
		{
			
			int t=Integer.parseInt((reade.readLine()));
			a[i]=t;
		}
		
		for(pass=0;pass<n-1;pass++)
		{
			for(j=0;j<n-1-pass;j++)
			{
				if(a[j]>a[j+1])
				{
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
				}
			}
		}
		System.out.println("array after pass"+pass+"");
		for(k=0;k<n;k++)
		{
		System.out.println(a[k]);	
		}
	}

}
