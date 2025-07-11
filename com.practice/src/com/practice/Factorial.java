package com.practice;

import java.util.Scanner;

public class Factorial {
	int fact=1;
	int n=1;
	
	int calFact(int n) 
	{
		if(n>=1) 
		return (n*calFact(n-1));
		return 1;
	}

	public static void main(String[] args) 
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of which you want factorial");
		int number=scan.nextInt();
		Factorial ob=new Factorial();
		int result=ob.calFact(number);
		//method 1
//		for(int i=1;i<=number;i++)
//		{
//			 fact=fact*i;
//		}
		
//		method 2
//		for(int i=number;i>=1;i--)
//		{
//			fact=fact*i;
//		}

		System.out.println("Factorial of the number is "+result);
	}

}
