package com.practice;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int temp=0;
		System.out.println("Enter the number you want to check for prime or non prime");
		int number=scan.nextInt();
		
		for(int i=2;i<number;i++)
		{
			if(number%i==0)
			{
				temp=temp+1;
			}
			if(temp>0)
			{
				System.out.println("not a prime number");
				break;
			}
		}
		if(temp==0) {
			System.out.println("Number is Prime");
		}
		
		//  Printing prime number between 1-100
		
//		System.out.println("Primenumber are");
//		for(int i=1;i<=100;i++)
//		{  int temp1=0;
//			for(int j=2;j<i;j++)
//			{
//				if(i%j==0)
//				{
//					temp1=temp1+1;
//				}
//			}
//			if(temp1<=0)
//			{
//				System.out.print(i+" ");
//			}
//		}

	}

}
