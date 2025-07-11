package com.practice;

import java.util.Scanner;

public class NumberPattern {

	
	public static void main(String[] args) {

		int count=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the pattern length you want");
		int n=scan.nextInt();
		for(int i=1;i<=n;i++)
		{
			if(i%2!=0)
			{
			
					for(int j=1;j<=3;j++)
					{
						count=count+1;
						System.out.print(count+" ");
						
					}
			}
			else
			{
				int temp=count+1;
				for(int k=count+3;k>=temp;k--)
				{
					count=count+1;
					System.out.print(k+" ");
				}
				
				
			}
			System.out.println();
		}

	}

}
