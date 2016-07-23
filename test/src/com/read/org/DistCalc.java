package com.read.org;

import java.util.Scanner;

public class DistCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String line=null;
		int a[]=new int[25];
		int i=0;
		try{
		while( i<5)
		{
			a[i]=s.nextInt();
			i++;
		}
		for (int k=0;k<a.length;k++)
		{
			// System.out.println(a[k]);
			int sum=getDistance(a[k]);
			System.out.println(a[k]+"sume---------"+sum);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static int getDistance(int a) {
		// TODO Auto-generated method stub
		int[] b={20,10,5};
		int j=0,sum=0;
		for(int i=0;i<a;i++)
		{
			
			if(j<b.length)
			{
				sum+=b[j];
				j++;
			}
			else
			{
				j=0;
				sum+=b[j];
			}
			
		}
		return sum;
	}

}
