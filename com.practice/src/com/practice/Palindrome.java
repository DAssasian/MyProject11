package com.practice;

import java.util.Scanner;

public class Palindrome {
	
	public static void main(String[] args) {
		
		int rem=0,rev=0;
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the number you want to check");
		int number=scan.nextInt();
		int temp=number;
		
		while(number!=0)
		{
			rem=number%10;
			number=number/10;
			rev=rev*10+rem;
		}
		
		if(temp==rev)
		{
			System.out.println("Entered number is Palindrome number");
		}
		else
		{
			System.out.println("Entered number is not Palindrome");
		}
					
	}

}
